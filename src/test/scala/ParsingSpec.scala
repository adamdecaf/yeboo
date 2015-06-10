package yeboo
import yeboo.utils._
import org.specs2.mutable.Specification

object ParsingSpec extends Specification with DirectoryUtils {
  "parse all passing files" in {
    val files = iterateAndStreamFiles("src/test/resources/passing-test-files/")
    files foreach println
    ok
  }
}
