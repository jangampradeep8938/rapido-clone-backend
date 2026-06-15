package com.rapido.analytics_service.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DashboardController {

    @GetMapping("/analytics/dashboard")
    public Map<String, Object> dashboard() {

        return Map.of(
                "activeRides", 120,
                "dailyRevenue", 250000,
                "activeDrivers", 850
        );
    }
}