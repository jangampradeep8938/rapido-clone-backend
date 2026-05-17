package com.rapido.ride_service.tracker;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DriverSimulationService {

    @Scheduled(fixedRate = 5000)
    public void simulateDriverMovement() {

        System.out.println(
                "Simulating Driver Location Update..."
        );
    }
}