package com.example.patterns_clean_architecture.patterns


interface ScenarioCommand {
    fun execute()
}

abstract class SuccessScenario : ScenarioCommand {}
abstract class FailScenario : ScenarioCommand {}

class PaymentMachine(
    private val successScenarios: List<SuccessScenario>,
    private val failScenarios: List<FailScenario>
) {

    fun run(){}

    private fun onSuccess(){
        successScenarios.forEach { it.execute() }
    }

    private fun onFail(){
        failScenarios.forEach { it.execute() }
    }
}

fun main() {

    val paymentMachine = PaymentMachine(
        listOf<SuccessScenario>(),
        listOf<FailScenario>()
    )
    paymentMachine.run()
}
