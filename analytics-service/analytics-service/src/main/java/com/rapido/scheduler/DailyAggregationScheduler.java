package com.rapido.analytics.scheduler;

import com.rapido.analytics.aggregation.KPIAggregationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyAggregationScheduler {

    private final KPIAggregationService kpiService;

    public DailyAggregationScheduler(KPIAggregationService kpiService) {
        this.kpiService = kpiService;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void generateDailyKPIs() {

        System.out.println("===== DAILY KPI REPORT =====");

        System.out.println("Total Rides: " + kpiService.getTotalRides());
        System.out.println("Completed Rides: " + kpiService.getCompletedRides());
        System.out.println("Cancelled Rides: " + kpiService.getCancelledRides());
        System.out.println("Revenue: " + kpiService.getRevenue());

        System.out.println("============================");
    }
}