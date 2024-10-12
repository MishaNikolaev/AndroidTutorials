package com.example.patterns_clean_architecture.patterns

import com.example.patterns_clean_architecture.Order
import com.example.patterns_clean_architecture.OrderInvoiceGenerator
import com.example.patterns_clean_architecture.OrderInvoiceGeneratorImpl
import com.example.patterns_clean_architecture.OrderNotificationSender
import com.example.patterns_clean_architecture.OrderNotificationSenderImpl
import com.example.patterns_clean_architecture.OrderRepository
import com.example.patterns_clean_architecture.OrderRepositoryImpl


// This is an aggregation of the OrderNotificationSender, OrderInvoiceGenerator, OrderRepository interfaces.
class OrdersServiceA(
    private val orderNotificationSender: OrderNotificationSender,
    private val orderInvoiceGenerator: OrderInvoiceGenerator,
    private val orderRepository: OrderRepository
) {

    fun save(order: Order) {
        orderRepository.save(order)
    }

    fun sendNotification(order: Order) {
        orderNotificationSender.sendNotification(order)
    }

    fun generateInvoice(order: Order) {
        orderInvoiceGenerator.generateInvoice(order)
    }
}

// this is a composition of the OrderNotificationSender, OrderInvoiceGenerator, OrderRepository interfaces.
class OrdersServiceC() {
    private val orderNotificationSender: OrderNotificationSender = OrderNotificationSenderImpl()
    private val orderInvoiceGenerator: OrderInvoiceGenerator = OrderInvoiceGeneratorImpl()
    private val orderRepository: OrderRepository = OrderRepositoryImpl()

    fun save(order: Order) {
        orderRepository.save(order)
    }

    fun sendOrderUpdateNotification(order: Order) {
        // sends notification about order updates to the user.
        orderNotificationSender.sendNotification(order)
    }

    fun generateInvoice(order: Order) {
        // generates invoice
        orderInvoiceGenerator.generateInvoice(order)
    }
}

// Kotlin delegates example
class OrdersServiceD(
    private val orderNotificationSender: OrderNotificationSender,
    private val orderInvoiceGenerator: OrderInvoiceGenerator,
    private val orderRepository: OrderRepository
) : OrderNotificationSender by orderNotificationSender,
    OrderInvoiceGenerator by orderInvoiceGenerator,
    OrderRepository by orderRepository {}



fun main() {
    val facade = OrdersServiceD(
        orderNotificationSender = OrderNotificationSenderImpl(),
        orderInvoiceGenerator = OrderInvoiceGeneratorImpl(),
        orderRepository = OrderRepositoryImpl()
    )
    val order = Order()
    facade.save(order)
    facade.sendNotification(order)
    facade.generateInvoice(order)
}
