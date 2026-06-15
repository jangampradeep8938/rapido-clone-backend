package com.rapido.analytics.aggregation;

import org.springframework.stereotype.Service;

@Service
public class KPIAggregationService {

    public int getTotalRides() {
        return 1000;
    }

    public int getCompletedRides() {
        return 850;
    }

    public int getCancelledRides() {
        return 150;
    }

    public double getRevenue() {
        return 250000.0;
    }

    public double getDriverUtilization() {
        return 82.5;
    }

    public double getAverageRideDuration() {
        return 18.4;
    }
}