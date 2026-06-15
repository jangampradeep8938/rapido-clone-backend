package com.rapido.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MonthlyAnalyticsJob {

    @Scheduled(cron = "0 0 2 1 * ?")
    public void generateMonthlyAnalytics() {

        System.out.println("===== MONTHLY ANALYTICS REPORT =====");

        System.out.println("Monthly Revenue: 5000000");
        System.out.println("Driver Performance: Excellent");
        System.out.println("Customer Retention: 85%");

        System.out.println("====================================");
    }
}