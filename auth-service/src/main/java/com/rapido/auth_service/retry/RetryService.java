package com.rapido.auth_service.retry;

import org.springframework.stereotype.Service;

@Service
public class RetryService {

    public void retryEvent(String eventId) {

        int maxRetries = 3;

        for (int i = 1; i <= maxRetries; i++) {

            System.out.println("Retry Attempt " + i + " for Event " + eventId);
        }

        System.out.println("Retry Process Completed");
    }
}