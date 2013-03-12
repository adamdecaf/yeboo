package yeboo

import java.io.File
import javax.imageio.ImageIO

object Runner {

  def main(args: Array[String]): Unit = {
    println("Generating File")
    generateAndSaveFile(args)
  }

  private[this] def readFile(args: Array[String]): String = {
    scala.io.Source.fromFile("examples/design.yeb").getLines.mkString("\n")
  }

  private[this] def generateAndSaveFile(args: Array[String]) = {
    lazy val img = new Interpreter().generate(readFile(args))
    ImageIO.write(img, "png", new File("examples/design-result.png"))
  }
}
