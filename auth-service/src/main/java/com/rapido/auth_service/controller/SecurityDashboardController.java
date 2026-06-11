package com.rapido.auth_service.controller;

import com.rapido.auth_service.repository.SecurityEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SecurityDashboardController {

    @Autowired
    private SecurityEventRepository securityEventRepository;

    @GetMapping("/admin/security/dashboard")
    public Map<String, Object> dashboard() {

        Map<String, Object> response = new HashMap<>();

        response.put(
                "failedLogins",
                securityEventRepository.countByEventType("LOGIN_FAILED")
        );

        response.put(
                "successfulLogins",
                securityEventRepository.countByEventType("LOGIN_SUCCESS")
        );

        response.put(
                "blockedAccounts",
                securityEventRepository.countByEventType("ACCOUNT_BLOCKED")
        );

        response.put(
                "totalSecurityEvents",
                securityEventRepository.count()
        );

        response.put("securityStatus", "ACTIVE");
        response.put("systemHealth", "HEALTHY");

        return response;
    }
}