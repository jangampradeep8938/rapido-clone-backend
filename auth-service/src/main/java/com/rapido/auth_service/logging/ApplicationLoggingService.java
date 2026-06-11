package com.rapido.auth_service.logging;

import org.springframework.stereotype.Service;

@Service
public class ApplicationLoggingService {

    public void logEvent(String message) {

        System.out.println("LOG: " + message);

    }
}