package com.rapido.notification_service.service;

import com.rapido.notification_service.dto.NotificationEvent;

public interface NotificationService {

    void sendNotification(
            NotificationEvent event
    );

    String sendOtp(
            String recipient
    );
}