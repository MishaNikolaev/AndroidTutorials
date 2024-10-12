package com.example.patterns_clean_architecture.patterns

import com.example.patterns_clean_architecture.Order
import com.example.patterns_clean_architecture.OrderInvoiceGenerator
import com.example.patterns_clean_architecture.OrderInvoiceGeneratorImpl
import com.example.patterns_clean_architecture.OrderNotificationSender
import com.example.patterns_clean_architecture.OrderNotificationSenderImpl
import com.example.patterns_clean_architecture.OrderRepository
import com.example.patterns_clean_architecture.OrderRepositoryImpl


/** PROVIDES A SIMPLE INTERFACE TO A COMPLEX CLASS SYSTEM */

class OrdersService(
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

fun main() {
    val ordersService = OrdersService(
        orderNotificationSender = OrderNotificationSenderImpl(),
        orderInvoiceGenerator = OrderInvoiceGeneratorImpl(),
        orderRepository = OrderRepositoryImpl()
    )

    val order = Order()
    ordersService.save(order)
    ordersService.sendNotification(order)
    ordersService.generateInvoice(order)
}