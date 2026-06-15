package com.rapido.metrics;

import org.springframework.stereotype.Service;

@Service
public class DriverUtilizationService {

    public double calculateUtilization(double completedRideHours, double onlineHours) {

        if (onlineHours == 0) {
            return 0;
        }

        return (completedRideHours / onlineHours) * 100;
    }
}