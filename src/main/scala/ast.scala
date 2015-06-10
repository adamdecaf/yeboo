package yeboo.ast

sealed trait AST {
  final def ++(other: AST): AST = ???
}

case object EmptyAST extends AST
