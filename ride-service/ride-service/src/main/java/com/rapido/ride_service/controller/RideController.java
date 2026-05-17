package com.rapido.ride_service.controller;

import com.rapido.ride_service.dto.RideRequestDTO;
import com.rapido.ride_service.event.DriverLocationEvent;
import com.rapido.ride_service.service.RideService;
import com.rapido.ride_service.tracker.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    @Autowired
    private TrackingService trackingService;

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

    @PostMapping("/driver/location/live")
    public ResponseEntity<?> updateLiveLocation(
            @RequestBody DriverLocationEvent event) {

        trackingService.processLocation(event);

        return ResponseEntity.ok("Location Updated");
    }
}