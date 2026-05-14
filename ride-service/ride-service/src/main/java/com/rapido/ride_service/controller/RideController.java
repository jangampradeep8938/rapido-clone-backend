package com.rapido.ride_service.controller;

import com.rapido.ride_service.dto.RideRequestDTO;
import com.rapido.ride_service.service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
@RequiredArgsConstructor
public class RideController {

    private final RideService rideService;

    @PostMapping("/request")
    public ResponseEntity<?> requestRide(
            @RequestBody RideRequestDTO dto,
            Authentication authentication) {

        return ResponseEntity.ok(
                rideService.requestRide(
                        authentication.getName(),
                        dto
                )
        );
    }

    @PutMapping("/{rideId}/accept")
    public ResponseEntity<?> acceptRide(
            @PathVariable Long rideId) {

        return ResponseEntity.ok(
                rideService.acceptRide(rideId)
        );
    }

    @PutMapping("/{rideId}/start")
    public ResponseEntity<?> startRide(
            @PathVariable Long rideId) {

        return ResponseEntity.ok(
                rideService.startRide(rideId)
        );
    }

    @PutMapping("/{rideId}/complete")
    public ResponseEntity<?> completeRide(
            @PathVariable Long rideId) {

        return ResponseEntity.ok(
                rideService.completeRide(rideId)
        );
    }

    @PutMapping("/{rideId}/cancel")
    public ResponseEntity<?> cancelRide(
            @PathVariable Long rideId) {

        return ResponseEntity.ok(
                rideService.cancelRide(rideId)
        );
    }
}