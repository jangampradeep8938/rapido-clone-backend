package com.rapido.analytics_service.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CityAnalyticsController {

    @GetMapping("/analytics/cities")
    public Map<String, Object> getCityAnalytics() {

        return Map.of(
                "topCities", "Hyderabad, Bangalore, Chennai",
                "revenueByCity", "Hyderabad:500000, Bangalore:400000, Chennai:300000",
                "rideDemandByCity", "Hyderabad:1200, Bangalore:1000, Chennai:800"
        );
    }
}