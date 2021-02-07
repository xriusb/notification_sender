package com.notification.sender;

public interface NotificationSender {
    void sendNotifications(String recipient, String subject, String message);
}
