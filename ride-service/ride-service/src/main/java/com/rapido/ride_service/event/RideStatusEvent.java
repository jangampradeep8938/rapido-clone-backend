package com.rapido.ride_service.event;

import com.rapido.ride_service.entity.RideStatus;

public class RideStatusEvent {

    private Long rideId;
    private RideStatus status;
    private String message;

    public RideStatusEvent() {
    }

    public static RideStatusEvent builder() {
        return new RideStatusEvent();
    }

    public RideStatusEvent rideId(Long rideId) {
        this.rideId = rideId;
        return this;
    }

    public RideStatusEvent status(RideStatus status) {
        this.status = status;
        return this;
    }

    public RideStatusEvent message(String message) {
        this.message = message;
        return this;
    }

    public RideStatusEvent build() {
        return this;
    }
}