package org.decaf.yeboo.parser
import java.awt.image.BufferedImage

trait ParsingFailure extends Exception
case object ImproperSyntax extends ParsingFailure

object Color extends Enumeration {
  val Red   = Value("r")
  val Green = Value("g")
  val Blue  = Value("b")
  val White = Value("w")
  val Black = Value("x")
}

case class Pixel(color: Color.Value)
case class LineDescription(repeatFrequency: Int, rowPixels: Iterable[Pixel])

case class FileDescription(lines: Iterable[LineDescription])
