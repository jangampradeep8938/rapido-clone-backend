package com.rapido.auth_service.service;

import com.rapido.auth_service.entity.SecurityEvent;
import com.rapido.auth_service.repository.SecurityEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SecurityEventService {

    @Autowired
    private SecurityEventRepository securityEventRepository;

    public void logEvent(
            String eventType,
            String username,
            String ipAddress) {

        SecurityEvent event = new SecurityEvent();

        event.setEventType(eventType);
        event.setUsername(username);
        event.setIpAddress(ipAddress);
        event.setEventTime(LocalDateTime.now());

        securityEventRepository.save(event);
    }
}