
package com.rapido.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeeklyAnalyticsJob {

    @Scheduled(cron = "0 0 1 * * MON")
    public void generateWeeklyAnalytics() {

        System.out.println("===== WEEKLY ANALYTICS REPORT =====");

        System.out.println("Weekly Revenue: 1500000");
        System.out.println("Weekly Ride Trends: Increasing");
        System.out.println("Top Cities: Hyderabad, Bangalore, Chennai");

        System.out.println("==================================");
    }
}