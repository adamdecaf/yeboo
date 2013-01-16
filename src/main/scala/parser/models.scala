package org.decaf.yeboo.parser

trait ParsingFailure extends Exception
case object ImproperSyntax extends ParsingFailure

object Colors extends Enumeration {
  val Red   = Value("r")
  val Green = Value("g")
  val Blue  = Value("b")
  val White = Value("w")
  val Black = Value("x")
}

case class Pixel(color: Colors.Value)
case class LineDescription(repeatFrequency: Int, rowPixels: List[Pixel])

case class FileDescription(lines: List[LineDescription])
