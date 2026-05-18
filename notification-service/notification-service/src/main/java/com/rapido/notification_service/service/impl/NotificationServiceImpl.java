package com.rapido.notification_service.service.impl;

import com.rapido.notification_service.dto.NotificationEvent;
import com.rapido.notification_service.entity.Notification;
import com.rapido.notification_service.entity.NotificationStatus;
import com.rapido.notification_service.entity.NotificationType;
import com.rapido.notification_service.repository.NotificationRepository;
import com.rapido.notification_service.service.EmailService;
import com.rapido.notification_service.service.NotificationService;
import com.rapido.notification_service.websocket.NotificationWebSocketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class NotificationServiceImpl
        implements NotificationService {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    NotificationServiceImpl.class
            );

    @Autowired
    private NotificationRepository
            notificationRepository;

    @Autowired
    private NotificationWebSocketService
            webSocketService;

    @Autowired
    private EmailService emailService;

    @Override
    @Async
    public void sendNotification(
            NotificationEvent event) {

        Notification notification =
                new Notification();

        notification.setUserId(
                event.getUserId()
        );

        notification.setType(
                event.getType()
        );

        notification.setRecipient(
                event.getRecipient()
        );

        notification.setTitle(
                event.getTitle()
        );

        notification.setMessage(
                event.getMessage()
        );

        notification.setStatus(
                NotificationStatus.SENT
        );

        notification.setRetryCount(0);

        notification.setCreatedAt(
                LocalDateTime.now()
        );

        notificationRepository.save(
                notification
        );

        if (event.getType() ==
                NotificationType.EMAIL) {

            emailService.sendEmail(
                    event.getRecipient(),
                    event.getTitle(),
                    event.getMessage()
            );
        }

        webSocketService.sendNotification(
                event
        );

        logger.info(
                "Notification Sent"
        );
    }

    @Override
    public String sendOtp(
            String recipient) {

        Random random = new Random();

        int otp =
                1000 + random.nextInt(9000);

        logger.info(
                "OTP Sent: {}",
                otp
        );

        return "OTP Sent Successfully";
    }
}