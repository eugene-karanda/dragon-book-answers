package chapter02.lexer

class Num(val value: Int) : Token {
    override val tag = Tag.NUM.tag
}