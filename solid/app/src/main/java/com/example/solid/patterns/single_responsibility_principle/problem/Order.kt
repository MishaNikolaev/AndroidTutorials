package com.example.solid.patterns.single_responsibility_principle.problem

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