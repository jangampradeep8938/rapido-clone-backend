package com.rapido.auth_service.dto;

public class SecurityDashboardResponse {

    private long failedLogins;
    private long successfulLogins;
    private long blockedAccounts;

    public SecurityDashboardResponse(
            long failedLogins,
            long successfulLogins,
            long blockedAccounts) {

        this.failedLogins = failedLogins;
        this.successfulLogins = successfulLogins;
        this.blockedAccounts = blockedAccounts;
    }

    public long getFailedLogins() {
        return failedLogins;
    }

    public void setFailedLogins(long failedLogins) {
        this.failedLogins = failedLogins;
    }

    public long getSuccessfulLogins() {
        return successfulLogins;
    }

    public void setSuccessfulLogins(long successfulLogins) {
        this.successfulLogins = successfulLogins;
    }

    public long getBlockedAccounts() {
        return blockedAccounts;
    }

    public void setBlockedAccounts(long blockedAccounts) {
        this.blockedAccounts = blockedAccounts;
    }
}