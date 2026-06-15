package com.rapido.analytics_service.warehouse;

import java.time.LocalDateTime;

public class AnalyticsJobAudit {

    private LocalDateTime jobStartTime;
    private LocalDateTime jobEndTime;
    private int recordsProcessed;
    private int failures;

    public AnalyticsJobAudit() {
    }

    public AnalyticsJobAudit(LocalDateTime jobStartTime,
                             LocalDateTime jobEndTime,
                             int recordsProcessed,
                             int failures) {
        this.jobStartTime = jobStartTime;
        this.jobEndTime = jobEndTime;
        this.recordsProcessed = recordsProcessed;
        this.failures = failures;
    }

    public LocalDateTime getJobStartTime() {
        return jobStartTime;
    }

    public void setJobStartTime(LocalDateTime jobStartTime) {
        this.jobStartTime = jobStartTime;
    }

    public LocalDateTime getJobEndTime() {
        return jobEndTime;
    }

    public void setJobEndTime(LocalDateTime jobEndTime) {
        this.jobEndTime = jobEndTime;
    }

    public int getRecordsProcessed() {
        return recordsProcessed;
    }

    public void setRecordsProcessed(int recordsProcessed) {
        this.recordsProcessed = recordsProcessed;
    }

    public int getFailures() {
        return failures;
    }

    public void setFailures(int failures) {
        this.failures = failures;
    }
}