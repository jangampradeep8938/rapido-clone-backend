package com.rapido.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbacController {

    @GetMapping("/abac/check")
    public String checkAccess(
            @RequestParam String role,
            @RequestParam String owner,
            @RequestParam String requester) {

        if ("SUPER_ADMIN".equals(role)) {
            return "ACCESS_GRANTED";
        }

        if (owner.equals(requester)) {
            return "ACCESS_GRANTED";
        }

        return "ACCESS_DENIED";
    }
}