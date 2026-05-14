package com.rapido.driverservice.controller;

import com.rapido.driverservice.dto.DriverProfileDTO;
import com.rapido.driverservice.service.DriverService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/profile")
    public ResponseEntity<DriverProfileDTO> getDriverProfile(
            Authentication authentication) {

        return ResponseEntity.ok(
                driverService.getProfile(authentication.getName())
        );
    }

    @PutMapping("/availability")
    public ResponseEntity<?> updateAvailability(
            @RequestParam Boolean available,
            Authentication authentication) {

        driverService.updateAvailability(
                authentication.getName(),
                available
        );

        return ResponseEntity.ok("Availability Updated");
    }

    @PutMapping("/online-status")
    public ResponseEntity<?> updateOnlineStatus(
            @RequestParam Boolean online,
            Authentication authentication) {

        driverService.updateOnlineStatus(
                authentication.getName(),
                online
        );

        return ResponseEntity.ok("Online Status Updated");
    }

    @PutMapping("/location")
    public ResponseEntity<?> updateLocation(
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            Authentication authentication) {

        driverService.updateLocation(
                authentication.getName(),
                latitude,
                longitude
        );

        return ResponseEntity.ok("Location Updated");
    }
}