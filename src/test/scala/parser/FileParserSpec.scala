package org.decaf.yeboo.parser

import org.specs2.specification.Scope
import org.specs2.mutable.Specification

object FileParserSpec extends Specification {

  "The FileParser" should {
    "parse some raw strings" in new context {
      FileParser.parseFileByRawString(sampleFile) === sampleResult
    }
  }

  trait context extends Scope {
    val sampleFile = """1 (1g) (2b)
    2 (2w)"""

    val sampleResult = FileDescription(List(
      LineDescription(1, List(Pixel(Colors.Green), Pixel(Colors.Blue), Pixel(Colors.Blue))),
      LineDescription(2, List(Pixel(Colors.White), Pixel(Colors.White)))
    ))
  }
}
