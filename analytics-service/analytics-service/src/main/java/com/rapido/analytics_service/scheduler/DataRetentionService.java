package com.rapido.analytics_service.scheduler;

import org.springframework.stereotype.Service;

@Service
public class DataRetentionService {

    public void archiveOldData() {
        System.out.println("Archiving old analytics data...");
    }

    public void cleanupExpiredRecords() {
        System.out.println("Cleaning up expired records...");
    }

    public String getRetentionPolicy() {
        return "Retain analytics data for 90 days";
    }
}