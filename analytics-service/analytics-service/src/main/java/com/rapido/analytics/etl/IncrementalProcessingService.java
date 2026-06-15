package com.rapido.analytics.etl;

import org.springframework.stereotype.Service;

@Service
public class IncrementalProcessingService {

    private long lastProcessedEventId = 0;

    public void processNewEvents(long currentEventId) {

        if (currentEventId > lastProcessedEventId) {
            System.out.println("Processing new event: " + currentEventId);

            lastProcessedEventId = currentEventId;
        } else {
            System.out.println("Skipping already processed event: " + currentEventId);
        }
    }
}