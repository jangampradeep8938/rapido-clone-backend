package com.rapido.auth_service.saga;

import org.springframework.stereotype.Service;

@Service
public class RideBookingOrchestrator {

    public void executeRideBooking() {

        System.out.println("Orchestration Saga Started");

        assignDriver();

        processPayment();

        sendNotification();

        System.out.println("Orchestration Saga Completed");
    }

    private void assignDriver() {
        System.out.println("Assign Driver Step");
    }

    private void processPayment() {
        System.out.println("Process Payment Step");
    }

    private void sendNotification() {
        System.out.println("Send Notification Step");
    }
}