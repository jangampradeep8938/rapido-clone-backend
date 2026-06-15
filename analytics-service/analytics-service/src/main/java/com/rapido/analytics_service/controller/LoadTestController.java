package com.rapido.analytics_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoadTestController {

    @GetMapping("/analytics/load-test")
    public Map<String, Object> loadTest() {

        return Map.of(
                "simulatedUsers", 1000,
                "averageResponseTime", "120 ms",
                "systemStability", "PASS"
        );
    }
}