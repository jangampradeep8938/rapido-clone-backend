package com.rapido.analytics_service.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HeatmapController {

    @GetMapping("/analytics/heatmap")
    public List<Map<String, Object>> getHeatmapData() {

        return List.of(
                Map.of(
                        "latitude", 17.3850,
                        "longitude", 78.4867,
                        "rideCount", 120
                ),
                Map.of(
                        "latitude", 12.9716,
                        "longitude", 77.5946,
                        "rideCount", 95
                ),
                Map.of(
                        "latitude", 13.0827,
                        "longitude", 80.2707,
                        "rideCount", 80
                )
        );
    }
}