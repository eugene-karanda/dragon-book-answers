package chapter02

import core.Analyser

/**
 * Build an analyzer that works by recursive
 * descent, for the following grammar
 * S -► + S S | - S S | а
 */
fun main(args: Array<String>) {
    eventLoop@ do {
        val expression = readLine()

        when (expression) {
            ".exit" -> break@eventLoop
            null -> continue@eventLoop
            else -> Analyser24c(expression).analyze()
        }
    } while (true)
}

class Analyser24c(expression: String): Analyser {

    private var charIterator: CharIterator = expression.iterator()

    private var token: Char? = '\u0000'

    override fun analyze() {
        readToken()
        s()
    }

    private fun readToken() {
        token = when(charIterator.hasNext()) {
            true -> charIterator.nextChar()
            false -> throw RuntimeException("Unexpected end of line")
        }
    }

    private fun s() {
        match('0')
        readToken()
        r()
    }

    private fun r() {
        when(token) {
            '1' -> {
                match('1')
            }
            else -> {
                s()
                readToken()
                match('1')
            }
        }
    }

    private fun match(expected: Char) {
        if(expected != token) {
            throw RuntimeException("Unexpected token '$token'")
        }
    }
}