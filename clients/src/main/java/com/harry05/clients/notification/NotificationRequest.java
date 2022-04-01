package com.harry05.clients.notification;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message) {
}