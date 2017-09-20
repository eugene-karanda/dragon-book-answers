package core

/**
 * @author eugene.karanda
 * @version 1.0 Create: 21.09.2017 1:13
 */
class ExpressionPeer(expression: String) {

    private val iterator: CharIterator = expression.iterator()

    private var current: Char? = null

    fun current(): Char? {
        return current
    }

    fun next(): Boolean {
        return when {
            iterator.hasNext() -> {
                current = iterator.nextChar()
                true
            }
            else -> {
                current = null
                false
            }
        }
    }

}