package com.rapido.analytics_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoggingController {

    @GetMapping("/analytics/logging")
    public Map<String, String> loggingStatus() {

        return Map.of(
                "analyticsJobs", "Logged",
                "apiRequests", "Logged",
                "failuresAndExceptions", "Logged"
        );
    }
}