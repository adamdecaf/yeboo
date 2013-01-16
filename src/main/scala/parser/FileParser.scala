package org.decaf.yeboo.parser

object FileParser extends FileParser

trait FileParser {
  // Sample line: 1 (1g) (2b)
  private[this] final val LINE_PATTERN = """^\d[\(\d[gb]\)]{1,}$""".r

  // def parseFileByPath(path: String): ImageDescription
  // def parseLine(line: String)

  def isValidLine(line: String): Boolean = removeSpaces(line) match {
    case LINE_PATTERN() => true
    case _              => false
  }

  private[this] def removeSpaces(str: String): String = {
    str.replaceAll("""\s""", "")
  }

}
