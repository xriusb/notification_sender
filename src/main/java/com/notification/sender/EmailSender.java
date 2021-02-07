package com.notification.sender;

public class EmailSender implements NotificationSender{
    @Override
    public void sendNotifications(String recipient, String subject, String message) {
        System.out.println("An email has been send to " + recipient +
                " with Subject" + subject + " and message: " + message);
    }
}
