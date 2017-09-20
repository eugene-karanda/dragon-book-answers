package chapter02.lexer

import core.SmartIterator

/**
 * @author eugene.karanda
 * @version 1.0 Create: 21.09.2017 0:45
 */
class Lexer(expression: String) {

    private var line: Int = 1

    private val iterator: SmartIterator = SmartIterator(expression.iterator())

    private val words: MutableMap<String, Word> = mutableMapOf()

    init {
        reserve(Word(Tag.TRUE.tag, "true"))
        reserve(Word(Tag.FALSE.tag, "false"))
    }

    private fun reserve(word: Word) {
        words.put(word.lexeme, word)
    }

    fun scan(): Token {
        var peek = iterator.next()

        whiteSpacesLoop@
        while (true) {
            when (peek) {
                ' ', '\t' -> continue@whiteSpacesLoop
                '\n' -> line++
                else -> break@whiteSpacesLoop
            }
        }

        return when {
            peek.isDigit() -> {
                var value = 0

                do {
                    value = 10 * value + Character.digit(peek, 10)
                    peek = iterator.next()
                } while (peek.isDigit())

                Num(value)
            }
            peek.isLetter() -> {
                val builder = StringBuilder()

                do {
                    builder.append(peek)
                    peek = iterator.next()
                } while (peek.isLetterOrDigit())

                words.computeIfAbsent(builder.toString(), { lexeme ->
                    Word(Tag.ID.tag, lexeme)
                })
            }
            else -> object : Token {
                override val tag: Int = peek.toInt()
            }
        }
    }

}

