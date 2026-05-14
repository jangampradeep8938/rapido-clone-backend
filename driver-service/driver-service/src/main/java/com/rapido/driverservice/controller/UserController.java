package com.rapido.driverservice.controller;

import com.rapido.driverservice.dto.UserProfileDTO;
import com.rapido.driverservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDTO> getProfile(
            Authentication authentication) {

        return ResponseEntity.ok(
                userService.getProfile(authentication.getName())
        );
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(
            @Valid @RequestBody UserProfileDTO dto,
            Authentication authentication) {

        userService.updateProfile(
                authentication.getName(),
                dto
        );

        return ResponseEntity.ok("Profile Updated");
    }
}