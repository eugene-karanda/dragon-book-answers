package chapter02

import io.kotlintest.specs.StringSpec

/**
 * @author eugene.karanda
 * @version 1.0 Create: 19.09.2017 23:30
 */
class Analyser24bSpec : StringSpec() {
    init {
        listOf("()", "()()", "(())", "(()())(())((())())")
                .forEach { expression ->
                    "should parse expression '$expression'" {
                        Analyser24b(expression).analyze()
                    }
                }
    }
}