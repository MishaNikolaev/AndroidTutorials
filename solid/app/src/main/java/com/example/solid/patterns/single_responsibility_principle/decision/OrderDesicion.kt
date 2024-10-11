package com.example.solid.patterns.single_responsibility_principle.decision

interface OrderNotificationSender{
    fun sendOrderUpdateNotification()
}

interface OrderInvoiceGeneration{
    fun generateInvoice()
}

interface SaveRepository{
    fun save()
}