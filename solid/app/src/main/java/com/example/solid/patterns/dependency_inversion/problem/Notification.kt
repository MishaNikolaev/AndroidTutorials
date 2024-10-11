package com.example.solid.patterns.dependency_inversion.problem

class SMSNotification {
    fun send() {
        // send sms notification
    }
}

class NotificationService {

    fun sendNotification(notification: SMSNotification) {
        notification.send()
    }
}

//notification: SMSNotification is implementation dependent, and we should depend on abstraction