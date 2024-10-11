package com.example.solid.patterns.open_closed_principle.problem

// Try to add one more type of notification
// for example SMS
enum class Notification {
    PUSH_NOTIFICATION, EMAIL //Try to add element in enum like SMS
}

class NotificationService {

    fun sendNotification(notification: Notification) {
        when (notification) {
            Notification.PUSH_NOTIFICATION -> {
                // send push notification
            }

            Notification.EMAIL -> {
                // send email notification
            }

            /*Notification.EMAIL -> {
                // send sms notification
            }
             */
        }
        //So we've had a change in class. This is antagonize our principle
        //We need another realization.
    }
}