package com.rapido.notification_service.controller;

import com.rapido.notification_service.dto.NotificationEvent;
import com.rapido.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService
            notificationService;

    @PostMapping("/notifications/send")
    public ResponseEntity<?> sendNotification(
            @RequestBody NotificationEvent event) {

        notificationService
                .sendNotification(event);

        return ResponseEntity.ok(
                "Notification Sent"
        );
    }

    @GetMapping("/notifications/history")
    public ResponseEntity<?> getHistory() {

        return ResponseEntity.ok(
                "Notification History"
        );
    }

    @PostMapping("/notifications/otp")
    public ResponseEntity<?> sendOtp(
            @RequestParam String recipient) {

        return ResponseEntity.ok(
                notificationService.sendOtp(
                        recipient
                )
        );
    }
}