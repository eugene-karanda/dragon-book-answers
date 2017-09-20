package core

/**
 * @author eugene.karanda
 * @version 1.0 Create: 21.09.2017 1:31
 */
class SmartIterator(private val delegate: Iterator<Char>) : Iterator<Char> {

    private var current: Char? = null

    override fun hasNext(): Boolean = delegate.hasNext()

    override fun next(): Char {
        return delegate.next().also { next ->
            current = next
        }
    }

    fun current(): Char? {
        return current
    }
}