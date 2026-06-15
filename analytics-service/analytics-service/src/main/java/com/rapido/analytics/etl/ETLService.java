package com.rapido.analytics.etl;

import org.springframework.stereotype.Service;

@Service
public class ETLService {

    public void processEvent(String eventType, String payload) {

        System.out.println("ETL Started for: " + eventType);

        // Validation
        if(payload == null || payload.isEmpty()) {
            System.out.println("Invalid Event");
            return;
        }

        // Transformation
        String transformedData = payload.toUpperCase();

        // Load
        System.out.println("Loaded into Analytics Warehouse: " + transformedData);

        System.out.println("ETL Completed");
    }
}