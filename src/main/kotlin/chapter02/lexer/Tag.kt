package chapter02.lexer

enum class Tag(val tag: Int) {
    NUM(256),
    ID(257),
    TRUE(258),
    FALSE(259)
}