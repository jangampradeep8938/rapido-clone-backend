package com.rapido.analytics_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MonitoringController {

    @GetMapping("/analytics/health")
    public Map<String, String> healthCheck() {

        return Map.of(
                "apiHealth", "UP",
                "databaseHealth", "UP",
                "kafkaHealth", "UP"
        );
    }
}