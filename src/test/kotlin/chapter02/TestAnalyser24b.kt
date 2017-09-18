package chapter02

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

/**
 * @author eugene.karanda
 * @version 1.0 Create: 19.09.2017 0:48
 */
class TestAnalyser24b : Spek({

    val expressions = listOf("()", "()()", "(())", "(()())(())((())())")

    expressions.forEach { expression ->
        it("should analyze '$expression'") {
            val analyser = Analyser24b(expression)
            analyser.analyze()
        }
    }
})