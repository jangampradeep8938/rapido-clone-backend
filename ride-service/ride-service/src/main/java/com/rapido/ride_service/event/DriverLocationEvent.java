package com.rapido.ride_service.event;

import java.time.LocalDateTime;

public class DriverLocationEvent {

    private Long rideId;
    private Long driverId;
    private Double latitude;
    private Double longitude;
    private LocalDateTime timestamp;

    public Long getRideId() {
        return rideId;
    }
}