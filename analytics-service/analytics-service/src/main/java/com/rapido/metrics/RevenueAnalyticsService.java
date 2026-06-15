package com.rapido.metrics;

import org.springframework.stereotype.Service;

@Service
public class RevenueAnalyticsService {

    public double getDailyRevenue() {
        return 250000.0;
    }

    public double getRevenueByCity() {
        return 1200000.0;
    }

    public double getRevenueByDriver() {
        return 50000.0;
    }

    public double getPlatformCommission() {
        return 150000.0;
    }
}