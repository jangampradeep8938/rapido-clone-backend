package com.rapido.analytics_service.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BusinessKPIDashboardController {

    @GetMapping("/analytics/kpi-dashboard")
    public Map<String, Object> getKPIDashboard() {

        return Map.of(
                "activeRides", 120,
                "activeDrivers", 850,
                "revenue", 250000,
                "rideSuccessRate", "92%",
                "averageETA", "6 minutes"
        );
    }
}