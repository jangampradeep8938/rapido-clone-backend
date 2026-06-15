package com.rapido.analytics_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FraudAnalyticsController {

    @GetMapping("/analytics/fraud")
    public Map<String, Object> detectFraud() {

        return Map.of(
                "fakeRideRequests", 12,
                "suspiciousDriverActivity", 5,
                "multipleCancellations", 18
        );
    }
}