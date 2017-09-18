package chapter02

import core.Analyser

/**
 * Build an analyzer that works by recursive
 * descent, for the following grammar
 * S -► + S S | - S S | а
 */
class Analyser24a(expression: String): Analyser {

    private val charIterator: CharIterator = expression.iterator()

    private var token: Char? = '\u0000'

    override fun analyze() {
        s()
    }

    private fun readToken() {
        token = when(charIterator.hasNext()) {
            true -> charIterator.nextChar()
            false -> throw RuntimeException("Unexpected end of line")
        }
    }

    private fun s() {
        readToken()

        when (token) {
            '+', '-' -> {
                s()
                s()
            }
            'a' -> return
            else -> throw RuntimeException("Unexpected token '$token'")
        }
    }
}

fun main(args: Array<String>) {
    eventLoop@ do {
        val expression = readLine()

        when (expression) {
            ".exit" -> break@eventLoop
            null -> continue@eventLoop
            else -> Analyser24a(expression).analyze()
        }
    } while (true)
}