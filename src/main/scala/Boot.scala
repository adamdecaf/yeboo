package org.decaf.yeboo

import java.io.File
import javax.imageio.ImageIO
import org.decaf.yeboo.parser.FileParser
import org.decaf.yeboo.images.ImageGeneration

object Runner {

  def main(args: Array[String]): Unit = {
    println("Generating File")

    val fileData = scala.io.Source.fromFile(inputFile(args)).getLines.mkString("\n")
    val data = FileParser.parseFileByRawString(fileData)
    val img = ImageGeneration.createImageFromFileDescription(data)

    ImageIO.write(img, "png", new File(outputDirectory(args)))
  }

  private[this] def outputDirectory(args: Array[String]): String = {
    "examples/design-result.png"
  }

  private[this] def inputFile(args: Array[String]): String = {
    "examples/design.yeb"
  }
}
