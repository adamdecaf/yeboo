package org.decaf.yeboo.parser

object FileParser extends FileParser

trait FileParser {
  // Sample line: 1 (1g) (2b)
  private[this] final val LINE_PATTERN = """^\d[\(\d[rgbwx]\)]{1,}$""".r
  private[this] final val LINE_EXTRACTION_REGEX = """(\d)([\d\w]+)""".r

  def parseFileByRawString(rawString: String): FileDescription = {
    //val lines = scala.io.Source.fromFile(path).getLines.toList
    val lines = rawString.split("\n")
    val parsedLines = lines.map {
      line =>
        parseLine(line) match {
          case Right(lineInfo) => lineInfo
          case Left(e)         => throw e
        }
    }
    FileDescription(parsedLines)
  }

  private[this] def parseLine(line: String): Either[ParsingFailure, LineDescription] = {
    val cleanedLine = removeSpaces(line)

    if (isValidLine(cleanedLine)) {
      Right(extractDataFromLine(cleanedLine))
    } else {
      Left(ImproperSyntax)
    }
  }

  private[this] def removeSpaces(str: String): String = {
    str.replaceAll("""\s""", "").trim
  }

  private[this] def isValidLine(line: String): Boolean = line match {
    case LINE_PATTERN() => true
    case _              => false
  }

  private[this] def extractDataFromLine(line: String): LineDescription = {
    val lineWithRepeat = line.replaceAll("""\)""","").replaceAll("""\("""," ").split(" ")
    val repeatFeq: Int = lineWithRepeat.head.toInt
    val rawPixels: Iterable[Pixel] = lineWithRepeat.drop(1).flatMap {
      block =>
        val (blockRepeatFreq: Int, blockColor: Color.Value) = (block.head.toString.toInt, Color.withName(block.last.toString))
        Iterator.range(1, blockRepeatFreq + 1).toIterable.map(_ => Pixel(blockColor)).toList
    }
    LineDescription(repeatFeq, rawPixels)
  }
}
