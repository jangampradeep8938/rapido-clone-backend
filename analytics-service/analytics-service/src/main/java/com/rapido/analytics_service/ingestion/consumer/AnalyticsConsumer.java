package com.rapido.analytics.ingestion.consumer;

import com.rapido.analytics.etl.ETLService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsConsumer {

    private final ETLService etlService;

    public AnalyticsConsumer(ETLService etlService) {
        this.etlService = etlService;
    }

    @KafkaListener(topics = "ride-completed", groupId = "analytics-group")
    public void consumeRideCompleted(String message) {
        etlService.processEvent("ride-completed", message);
    }

    @KafkaListener(topics = "payment-success", groupId = "analytics-group")
    public void consumePaymentSuccess(String message) {
        etlService.processEvent("payment-success", message);
    }

    @KafkaListener(topics = "driver-status-updated", groupId = "analytics-group")
    public void consumeDriverStatus(String message) {
        etlService.processEvent("driver-status-updated", message);
    }

    @KafkaListener(topics = "notification-sent", groupId = "analytics-group")
    public void consumeNotificationSent(String message) {
        etlService.processEvent("notification-sent", message);
    }
}