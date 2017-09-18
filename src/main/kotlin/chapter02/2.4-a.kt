package chapter02

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
            else -> Analyser24a(expression).s()
        }
    } while (true)
}

class Analyser24a(expression: String) {

    private val charIterator: CharIterator = expression.iterator()

    fun s() {
        val token = when (charIterator.hasNext()) {
            true -> charIterator.nextChar()
            false -> throw RuntimeException("Unexpected end of line")
        }

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
