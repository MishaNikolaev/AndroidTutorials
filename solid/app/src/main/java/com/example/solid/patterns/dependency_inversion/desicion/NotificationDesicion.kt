package com.example.solid.patterns.dependency_inversion.desicion

interface Notification{
    fun send()
}

class SMSNotification : Notification {
    override fun send() {
        // send sms notification
    }
}

class NotificationService {

    fun sendNotification(notification: Notification) {
        notification.send()
    }
}
