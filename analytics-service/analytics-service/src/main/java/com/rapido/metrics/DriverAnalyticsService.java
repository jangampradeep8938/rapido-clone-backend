package com.rapido.metrics;

import org.springframework.stereotype.Service;

@Service
public class DriverAnalyticsService {

    public double getAcceptanceRate() {
        return 95.0;
    }

    public double getCompletionRate() {
        return 92.0;
    }

    public double getCancellationRate() {
        return 8.0;
    }

    public double getAverageRating() {
        return 4.8;
    }
}