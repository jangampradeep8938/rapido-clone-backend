package com.rapido.auth_service.saga;

import org.springframework.stereotype.Service;

@Service
public class RideBookingSaga {

    public void startSaga() {

        System.out.println("Saga Started");

        assignDriver();

        boolean paymentSuccess = false;

        if (paymentSuccess) {
            sendNotification();
            System.out.println("Saga Completed");
        } else {
            compensateTransaction();
        }
    }

    private void assignDriver() {
        System.out.println("Driver Assigned");
    }

    private void sendNotification() {
        System.out.println("Notification Sent");
    }

    private void compensateTransaction() {
        System.out.println("Payment Failed");
        System.out.println("Driver Released");
        System.out.println("Ride Cancelled");
        System.out.println("Failure Notification Sent");
    }
}