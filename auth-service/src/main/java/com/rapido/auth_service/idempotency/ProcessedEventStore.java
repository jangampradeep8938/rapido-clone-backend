package com.rapido.auth_service.idempotency;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProcessedEventStore {

    private final Set<String> processedEvents = new HashSet<>();

    public boolean isProcessed(String eventId) {
        return processedEvents.contains(eventId);
    }

    public void markProcessed(String eventId) {
        processedEvents.add(eventId);
    }
}