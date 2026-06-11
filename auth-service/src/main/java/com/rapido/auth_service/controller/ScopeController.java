package com.rapido.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeController {

    @GetMapping("/scope/ride/read")
    public String rideRead() {
        return "ride.read scope validated";
    }

    @GetMapping("/scope/payment/read")
    public String paymentRead() {
        return "payment.read scope validated";
    }

    @GetMapping("/scope/admin/read")
    public String adminRead() {
        return "admin.read scope validated";
    }
}