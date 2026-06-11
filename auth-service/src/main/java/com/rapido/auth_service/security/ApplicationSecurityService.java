package com.rapido.auth_service.security;

import org.springframework.stereotype.Service;

@Service
public class ApplicationSecurityService {

    public boolean validateToken(String token) {

        if (token == null || token.isEmpty()) {
            return false;
        }

        System.out.println("Token Validated Successfully");

        return true;
    }
}