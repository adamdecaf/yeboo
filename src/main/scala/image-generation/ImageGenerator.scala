package org.decaf.yeboo.images

import java.awt.Color
import java.awt.image.BufferedImage
import org.decaf.yeboo.parser.{Colors, FileDescription, LineDescription}

object ImageGeneration extends ImageGeneration

trait ImageGeneration {
  private[this] final val RED   = Color.RED.getRGB()
  private[this] final val GREEN = Color.GREEN.getRGB()
  private[this] final val BLUE  = Color.BLUE.getRGB()
  private[this] final val WHITE = Color.WHITE.getRGB()
  private[this] final val BLACK = Color.BLACK.getRGB()

  // TODO: Need to flatten out the repeatFrequency
  def createImageFromFileDescription(fileDesc: FileDescription): BufferedImage = {
    val (rows, cols) = calculateImageSize(fileDesc.lines)
    val finalImage = new BufferedImage(cols, rows, BufferedImage.TYPE_INT_ARGB)

    for (y <- (0 to (rows-1))) {
      for (x <- (0 to (cols-1))) {
        try {
          val rgb = getRawColor(fileDesc.lines(y).rowPixels(x).color)
          finalImage.setRGB(x, y, rgb)
        } catch {
          case _ =>
        }
      }
    }

    finalImage
  }

  private[this] def calculateImageSize(image: List[LineDescription]): Pair[Int, Int] = {
    val rows = image.length
    val cols: Int = image.maxBy(_.rowPixels.length).rowPixels.length
    Pair(rows, cols)
  }

  private[this] def getRawColor(c: Colors.Value): Int = c match {
    case Colors.Red   => RED
    case Colors.Green => GREEN
    case Colors.Blue  => BLUE
    case Colors.White => WHITE
    case Colors.Black => BLACK
  }
}
