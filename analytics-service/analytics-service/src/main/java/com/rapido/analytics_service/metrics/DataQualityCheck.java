package com.rapido.analytics_service.metrics;

import org.springframework.stereotype.Service;

@Service
public class DataQualityCheck {

    public boolean hasMissingFields(String event) {
        return event == null || event.isBlank();
    }

    public boolean isInvalidEvent(String event) {
        return !event.contains("ride");
    }

    public boolean isDuplicateEvent(String event) {
        return false;
    }
}