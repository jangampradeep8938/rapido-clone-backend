package com.rapido.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/auth/test")
    public String test() {
        return "Auth Service Working Successfully!";
    }

    @GetMapping("/auth/token")
    public String token() {
        return "JWT Test Endpoint";
    }
}