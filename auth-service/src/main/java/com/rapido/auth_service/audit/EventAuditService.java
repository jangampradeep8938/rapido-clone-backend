package com.rapido.auth_service.audit;

import org.springframework.stereotype.Service;

@Service
public class EventAuditService {

    public void auditEvent(String eventId, String eventType) {

        System.out.println("Audit Log Created");

        System.out.println("Event ID: " + eventId);

        System.out.println("Event Type: " + eventType);
    }
}