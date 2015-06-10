package yeboo.lexing
import yeboo.ast.AST

sealed trait LexingResult {
  final def ++(other: LexingResult): LexingResult = (this, other) match {
    case (LexingPassed(a1), LexingPassed(a2)) => LexingPassed(a1 ++ a2)
    case (LexingFailed(r1), LexingFailed(r2)) => LexingFailed(r1 ++ r2)
    case (_, LexingFailed(r)) => LexingFailed(r)
    case (LexingFailed(r), _) => LexingFailed(r)
  }
}

case class LexingFailed(reasons: List[String]) extends LexingResult
case class LexingPassed(ast: AST) extends LexingResult

object LexingFailed {
  def apply(reason: String): LexingResult = LexingFailed(List(reason))
}
