package com.example.solid.patterns.open_closed_principle.decision

interface Notification {
    fun send()
}

class PushNotification : Notification {
    override fun send() {
        // send push notification
    }
}

class EmailNotification : Notification {
    override fun send() {
        // send email notification
    }
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