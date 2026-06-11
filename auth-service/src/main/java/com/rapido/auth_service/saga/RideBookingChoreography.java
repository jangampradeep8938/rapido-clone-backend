package com.rapido.auth_service.saga;

import org.springframework.stereotype.Service;

@Service
public class RideBookingChoreography {

    public void executeChoreography() {

        System.out.println("RideRequested Event");

        System.out.println("DriverAssigned Event");

        System.out.println("PaymentCompleted Event");

        System.out.println("RideConfirmed Event");
    }
}