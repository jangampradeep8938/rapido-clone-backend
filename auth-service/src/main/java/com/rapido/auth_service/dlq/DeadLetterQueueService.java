package com.rapido.auth_service.dlq;

import org.springframework.stereotype.Service;

@Service
public class DeadLetterQueueService {

    public void sendToDLQ(String eventId, String reason) {

        System.out.println("Event moved to DLQ");

        System.out.println("Event ID: " + eventId);

        System.out.println("Reason: " + reason);
    }
}