package com.rapido.ride_service.service;

import com.rapido.ride_service.dto.RideRequestDTO;
import com.rapido.ride_service.entity.Ride;

public interface RideService {

    Ride requestRide(String email, RideRequestDTO dto);

    Ride acceptRide(Long rideId);

    Ride startRide(Long rideId);

    Ride completeRide(Long rideId);

    Ride cancelRide(Long rideId);
}