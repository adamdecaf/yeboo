package yeboo.lexing
import yeboo.ast._
import java.io.File

trait Lexing {
  def attemptToLexFile(file: File): LexingResult = {
    val reader = new LexingReader(file)

    @annotation.tailrec
    def parseTokenToAST(accum: LexingResult = LexingPassed(EmptyAST)): LexingResult = {
      if (reader.endOfFile()) {
        accum
      } else {
        val token = reader.readUntilWhitespace()
        if (liftStringToToken.isDefinedAt(token)) {
          parseTokenToAST(accum ++ LexingPassed(liftStringToToken(token)))
        } else {
          LexingFailed(s"Can't lift ${token} to known ast element.")
        }
      }
    }

    parseTokenToAST()
  }

  private[this] def liftStringToToken: PartialFunction[String, AST] = {
    case str if isMethodCall(str) => ???
  }

  private[this] def isMethodCall(str: String): Boolean = true
}
