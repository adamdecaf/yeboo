package yeboo.lexing
import java.io.{File, FileReader}
import scala.collection.mutable.StringBuilder

class LexingReader(file: File) {
  def endOfFile(): Boolean = reader.ready()

  def skipPastWhitespace(): Unit = {
    reader.mark(1)
    while(isWhiteSpace(reader.read().toChar)) {
      reader.mark(1)
    }
    reader.reset()
  }

  def readUntilWhitespace(): String = {
    val builder = StringBuilder.newBuilder
    reader.mark(1)

    var continue = true
    while(continue) {
      val char = reader.read().toChar
      if (!isWhiteSpace(char)) {
        builder += char
        reader.mark(1)
      } else {
        continue = false
      }
    }

    builder.toString
  }

  private[this] val reader = new FileReader(file)

  private[this] val WhiteSpaceCharacters = List(' ', '\n', '\r')
  private[this] def isWhiteSpace(char: Char): Boolean = WhiteSpaceCharacters.exists(_ == char)
}
