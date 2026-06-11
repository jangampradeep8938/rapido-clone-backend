package com.rapido.auth_service.failuresimulation;

import org.springframework.stereotype.Service;

@Service
public class FailureSimulationService {

    public void simulateFailure() {

        try {

            throw new RuntimeException("Simulated Failure");

        } catch (Exception e) {

            System.out.println("Failure Captured: " + e.getMessage());
        }
    }
}