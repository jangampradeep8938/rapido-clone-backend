package com.rapido.metrics;

import org.springframework.stereotype.Service;

@Service
public class CustomerAnalyticsService {

    public int getNewCustomers() {
        return 500;
    }

    public int getReturningCustomers() {
        return 1200;
    }

    public double getChurnRate() {
        return 8.5;
    }

    public double getRetentionRate() {
        return 91.5;
    }
}