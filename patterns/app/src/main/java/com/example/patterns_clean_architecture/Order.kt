package com.example.patterns_clean_architecture


class Order {
    fun sendOrderUpdateNotification() {
        // sends notification about order updates to the user.
    }

    fun generateInvoice() {
        // generates invoice
    }

    fun save() {
        // insert/update data in the db
    }
}


interface OrderNotificationSender {
    fun sendNotification(order: Order)
}

interface OrderInvoiceGenerator {
    fun generateInvoice(order: Order)
}

interface OrderRepository {
    fun save(order: Order)
}

class OrderNotificationSenderImpl : OrderNotificationSender {
    override fun sendNotification(order: Order) {
        // sends notification about order updates to the user.
    }
}

class OrderInvoiceGeneratorImpl : OrderInvoiceGenerator {
    override fun generateInvoice(order: Order) {
        // generates invoice
    }
}

class OrderRepositoryImpl : OrderRepository {
    override fun save(order: Order) {
        // insert/update data in the db
    }
}
