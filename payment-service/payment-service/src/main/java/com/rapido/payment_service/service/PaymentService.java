package com.rapido.payment_service.service;

public interface PaymentService {

    void topUpWallet(
            String email,
            Double amount
    );

    Double getBalance(String email);

    String processRidePayment(
            String email,
            Long rideId
    );

    String refundRide(Long rideId);
}