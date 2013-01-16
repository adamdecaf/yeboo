package org.decaf.yeboo.images

import javax.imageio.ImageIO
import java.io.{File, FileInputStream}
import java.awt.image.BufferedImage
import org.specs2.specification.Scope
import org.specs2.mutable.Specification
import org.decaf.yeboo.parser.{Colors, FileDescription, LineDescription, Pixel}

object ImageGenerationSpec extends Specification {

  "The ImageGeneration" should {
    "parse some raw strings" in new context {
      val generatedImage = ImageGeneration.createImageFromFileDescription(sampleInput)
      //writeImage(generatedImage)
      compare(generatedImage, validImage) must beTrue
    }
  }

  trait context extends Scope {
    val sampleInput = FileDescription(List(
      LineDescription(1, List(Pixel(Colors.Green), Pixel(Colors.Blue), Pixel(Colors.Blue))),
      LineDescription(2, List(Pixel(Colors.White), Pixel(Colors.White)))
    ))

    lazy val fileStream = new FileInputStream(new File("src/test/resources/validImage.png"))
    lazy val validImage: BufferedImage = ImageIO.read(fileStream)

    def compare(img1: BufferedImage, img2: BufferedImage): Boolean = {
      if ((img1.getHeight != img2.getHeight) || (img1.getWidth != img2.getWidth)) {
        return false
      }

      val rows = 0 to (img1.getHeight - 1)
      val cols = 0 to (img1.getWidth - 1)

      for (y <- rows) {
        for (x <- cols) {
          if (img1.getRGB(x,y) != img2.getRGB(x,y)) return false
        }
      }

      return true
    }

    def writeImage(img: BufferedImage) {
      ImageIO.write(img, "png", new File("src/test/resources/testImage.png"))
    }
  }
}
