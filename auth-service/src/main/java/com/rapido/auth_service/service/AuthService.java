package com.rapido.auth_service.service;

import com.rapido.auth_service.dto.LoginRequest;
import com.rapido.auth_service.dto.RegisterRequest;
import com.rapido.auth_service.entity.User;
import com.rapido.auth_service.repository.UserRepository;
import com.rapido.auth_service.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private SecurityEventService securityEventService;

    @Autowired
    private LoginAttemptService loginAttemptService;

    public String register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepository.save(user);

        securityEventService.logEvent(
                "REGISTER_SUCCESS",
                user.getEmail(),
                "127.0.0.1"
        );

        return "Registered Successfully";
    }

    public String login(LoginRequest request) {

        if (loginAttemptService.isBlocked(request.getEmail())) {

            securityEventService.logEvent(
                    "ACCOUNT_BLOCKED",
                    request.getEmail(),
                    "127.0.0.1"
            );

            throw new RuntimeException(
                    "Account locked after 5 failed attempts"
            );
        }

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            loginAttemptService.loginFailed(
                    request.getEmail()
            );

            securityEventService.logEvent(
                    "LOGIN_FAILED",
                    request.getEmail(),
                    "127.0.0.1"
            );

            throw new RuntimeException("Invalid credentials");
        }

        loginAttemptService.loginSucceeded(
                request.getEmail()
        );

        securityEventService.logEvent(
                "LOGIN_SUCCESS",
                user.getEmail(),
                "127.0.0.1"
        );

        return jwtUtil.generateToken(user.getEmail());
    }
}