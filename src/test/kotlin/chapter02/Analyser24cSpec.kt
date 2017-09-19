package chapter02

import io.kotlintest.specs.StringSpec

/**
 * @author eugene.karanda
 * @version 1.0 Create: 19.09.2017 23:30
 */
class Analyser24cSpec : StringSpec() {
    init {
        listOf("01", "0011", "000111", "0000011111")
                .forEach { expression ->
                    "should parse expression '$expression'" {
                        Analyser24c(expression).analyze()
                    }
                }
    }
}