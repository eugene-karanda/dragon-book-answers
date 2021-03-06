package chapter02

import core.Analyser

/**
 * Build an analyzer that works by recursive
 * descent, for the following grammar
 * S -► + S S | - S S | а
 */
class Analyser24b(expression: String) : Analyser {

    private val charIterator: CharIterator = expression.iterator()

    private var token: Char? = '\u0000'

    override fun analyze() {
        readToken()
        s()
    }

    private fun readToken() {
        token = when(charIterator.hasNext()) {
            true -> charIterator.nextChar()
            false -> null
        }
    }

    private fun s() {
        r()
    }

    private fun r() {
        when(token) {
            '(' -> {
                readToken()
                s()
                match(')')
                readToken()
                s()
            }
        }
    }

    private fun match(expected: Char) {
        if(expected != token) {
            throw RuntimeException("Unexpected token '$token'")
        }
    }
}

fun main(args: Array<String>) {
    eventLoop@ do {
        val expression = readLine()

        when (expression) {
            ".exit" -> break@eventLoop
            null -> continue@eventLoop
            else -> Analyser24b(expression).analyze()
        }
    } while (true)
}