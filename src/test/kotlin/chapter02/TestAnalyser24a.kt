package chapter02

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

/**
 * @author eugene.karanda
 * @version 1.0 Create: 19.09.2017 0:48
 */
class TestAnalyser24a : Spek({

    val expressions = listOf("a", "+aa", "+a+a-aaaaa")

    expressions.forEach { expression ->
        it("should analyze '$expression'") {
            val analyser = Analyser24a(expression)
            analyser.analyze()
        }
    }
})