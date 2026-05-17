package com.rapido.payment_service.controller;

import com.rapido.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/wallet/topup")
    public ResponseEntity<?> topUpWallet(
            @RequestParam Double amount,
            Authentication authentication) {

        paymentService.topUpWallet(
                authentication.getName(),
                amount
        );

        return ResponseEntity.ok(
                "Wallet Recharged"
        );
    }

    @GetMapping("/wallet/balance")
    public ResponseEntity<?> getBalance(
            Authentication authentication) {

        return ResponseEntity.ok(
                paymentService.getBalance(
                        authentication.getName()
                )
        );
    }

    @PostMapping("/payment/pay")
    public ResponseEntity<?> payForRide(
            @RequestParam Long rideId,
            Authentication authentication) {

        return ResponseEntity.ok(
                paymentService.processRidePayment(
                        authentication.getName(),
                        rideId
                )
        );
    }

    @PostMapping("/payment/refund")
    public ResponseEntity<?> refundRide(
            @RequestParam Long rideId) {

        return ResponseEntity.ok(
                paymentService.refundRide(rideId)
        );
    }

    @GetMapping("/transactions/history")
    public ResponseEntity<?> getTransactionHistory() {

        return ResponseEntity.ok(
                "Transaction History API Working"
        );
    }
}