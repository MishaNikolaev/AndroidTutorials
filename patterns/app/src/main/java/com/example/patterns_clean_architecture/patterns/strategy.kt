package com.example.patterns_clean_architecture.patterns


/**
 *  STRATEGY DESIGN PATTERN IS A PATTERN WITH WHICH
 *  WE ENCAPSULATE A FAMILY OF ALGORITHMS AND MAKES THEM
 *  INTERCHANGEABLE.
 */

interface Algorithm<T> {
    fun execute(data: T)
}

class SortAlgorithm : Algorithm<List<Int>> {
    override fun execute(data: List<Int>) {
        println("Sort algorithm")
    }
}

class SearchAlgorithm : Algorithm<List<Int>> {
    override fun execute(data: List<Int>) {
        println("Search algorithm")
    }
}

class BinarySortAlgorithm : Algorithm<List<Int>> {
    override fun execute(data: List<Int>) {
        println("Binary sort algorithm")
    }
}

class SearchAlgorithm1 : Algorithm<List<String>> {
    override fun execute(data: List<String>) {
        println("Search algorithm")
    }
}

fun <T> applyAlgorithm(data: T, algorithm: Algorithm<T>) {
    algorithm.execute(data)
}

fun main() {
    val sortAlgorithm = SortAlgorithm()
    val searchAlgorithm = SearchAlgorithm()
    val binarySortAlgorithm = BinarySortAlgorithm()
    val listInt = listOf(1, 3, 4)

    applyAlgorithm(listInt, sortAlgorithm)
    applyAlgorithm(listInt, searchAlgorithm)
    applyAlgorithm(listInt, binarySortAlgorithm)

    val listStrings = listOf("1", "3", "4")
    applyAlgorithm(listStrings, SearchAlgorithm1())
}

/***********************************************************************/

interface TaxStrategy {
    fun applyTo(income: Double): Double
}

class MarketingTaxStrategy : TaxStrategy {
    override fun applyTo(income: Double): Double {
        return income * 0.07
    }
}

class SalesTaxStrategy : TaxStrategy {
    override fun applyTo(income: Double): Double {
        return income * 0.05
    }
}

class EducationTaxStrategy : TaxStrategy {
    override fun applyTo(income: Double): Double {
        return income * 0
    }
}

class SalaryTaxStrategy : TaxStrategy {
    override fun applyTo(income: Double): Double {
        return income * 0.35
    }
}

abstract class Income(private val amount: Double, private val taxStrategy: TaxStrategy) {
    fun estimateTax(): Double {
        return taxStrategy.applyTo(amount)
    }
}

class Salary(amount: Double, taxStrategy: SalaryTaxStrategy) : Income(amount, taxStrategy) {}
class MarketingIncome(amount: Double, taxStrategy: MarketingTaxStrategy) :
    Income(amount, taxStrategy) {}

class SalesIncome(amount: Double, taxStrategy: SalesTaxStrategy) : Income(amount, taxStrategy) {}
class EducationIncome(amount: Double, taxStrategy: EducationTaxStrategy) :
    Income(amount, taxStrategy) {}

//fun main() {
//    val salary = Salary(1000.0, SalaryTaxStrategy())
//    val marketingIncome = MarketingIncome(400.0, MarketingTaxStrategy())
//    val salesIncome = SalesIncome(500.0, SalesTaxStrategy())
//    val educationIncome = EducationIncome(150.0, EducationTaxStrategy())
//
//    println(salary.estimateTax())
//    println(marketingIncome.estimateTax())
//    println(salesIncome.estimateTax())
//    println(educationIncome.estimateTax())
//}
