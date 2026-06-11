package com.rapido.auth_service.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginAttemptService {

    private final int MAX_ATTEMPTS = 5;

    private Map<String, Integer> attempts = new HashMap<>();

    public void loginSucceeded(String email) {
        attempts.remove(email);
    }

    public void loginFailed(String email) {
        attempts.put(
                email,
                attempts.getOrDefault(email, 0) + 1
        );
    }

    public boolean isBlocked(String email) {
        return attempts.getOrDefault(email, 0) >= MAX_ATTEMPTS;
    }
}