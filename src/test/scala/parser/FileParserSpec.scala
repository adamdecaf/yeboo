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

    val sampleResult = FileDescription(Iterable(
      LineDescription(1, Iterable(Pixel(Color.Green), Pixel(Color.Blue), Pixel(Color.Blue))),
      LineDescription(2, Iterable(Pixel(Color.White), Pixel(Color.White)))
    ))
  }
}
