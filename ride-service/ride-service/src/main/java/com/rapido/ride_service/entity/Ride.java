package com.rapido.ride_service.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rides")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long driverId;

    private Double pickupLatitude;
    private Double pickupLongitude;

    private Double dropLatitude;
    private Double dropLongitude;

    @Enumerated(EnumType.STRING)
    private RideStatus status;

    private Double estimatedDistance;
    private Double estimatedFare;

    private LocalDateTime requestedAt;
    private LocalDateTime completedAt;

    public Ride() {
    }

    public Long getId() {
        return id;
    }

    public static Ride builder() {
        return new Ride();
    }

    public Ride userId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Ride driverId(Long driverId) {
        this.driverId = driverId;
        return this;
    }

    public Ride pickupLatitude(Double pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
        return this;
    }

    public Ride pickupLongitude(Double pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
        return this;
    }

    public Ride dropLatitude(Double dropLatitude) {
        this.dropLatitude = dropLatitude;
        return this;
    }

    public Ride dropLongitude(Double dropLongitude) {
        this.dropLongitude = dropLongitude;
        return this;
    }

    public Ride status(RideStatus status) {
        this.status = status;
        return this;
    }

    public Ride estimatedDistance(Double estimatedDistance) {
        this.estimatedDistance = estimatedDistance;
        return this;
    }

    public Ride estimatedFare(Double estimatedFare) {
        this.estimatedFare = estimatedFare;
        return this;
    }

    public Ride requestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
        return this;
    }

    public Ride completedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    public Ride build() {
        return this;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}