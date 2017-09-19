package chapter02

/**
 * @author eugene.karanda
 * @version 1.0 Create: 20.09.2017 0:51
 */
fun main(args: Array<String>) {
    val parser25 = Parser25()
    parser25.expr()
    println()
}

class Parser25 {

    private var lookahead: Char = System.`in`.read().toChar()

    fun expr() {
        term()
        while(true) {
            when(lookahead) {
                '+' -> {
                    match('+')
                    term()
                    print('+')
                }
                '-' -> {
                    match('-')
                    term()
                    print('-')
                }
                else -> return
            }
        }
    }

    private fun term() {
        if(lookahead.isDigit()) {
            print(lookahead)
            match(lookahead)
        } else {
            throw RuntimeException("unexpected digit '$lookahead'")
        }

    }

    private fun match(expected: Char) {
        if(expected == lookahead) {
            lookahead = System.`in`.read().toChar()
        } else {
            throw RuntimeException("unexpected token '$lookahead'")
        }
    }

}