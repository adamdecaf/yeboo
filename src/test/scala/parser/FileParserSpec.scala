package org.decaf.yeboo.parser

import org.specs2.specification.Scope
import org.specs2.mutable.Specification

object FileParserSpec extends Specification {

  "The FileParser" should {
    "check that a valid line is valid" in new context {
      FileParser.isValidLine(validLine) must beTrue
      FileParser.isValidLine(invalidLine) must beFalse
    }
  }

  trait context extends Scope {
    val validLine = "1 (1g) (9b)"
    val invalidLine = "0 (1h)"
  }
}
