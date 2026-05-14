package com.rapido.ride_service.service.impl;

import com.rapido.ride_service.dto.RideRequestDTO;
import com.rapido.ride_service.entity.Ride;
import com.rapido.ride_service.entity.RideStatus;
import com.rapido.ride_service.repository.RideRepository;
import com.rapido.ride_service.service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;

    @Override
    public Ride requestRide(String email, RideRequestDTO dto) {

        Ride ride = Ride.builder()
                .userId(1L)
                .driverId(1L)
                .pickupLatitude(dto.getPickupLatitude())
                .pickupLongitude(dto.getPickupLongitude())
                .dropLatitude(dto.getDropLatitude())
                .dropLongitude(dto.getDropLongitude())
                .status(RideStatus.REQUESTED)
                .estimatedDistance(10.0)
                .estimatedFare(120.0)
                .requestedAt(LocalDateTime.now())
                .build();

        return rideRepository.save(ride);
    }

    @Override
    public Ride acceptRide(Long rideId) {

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride Not Found"));

        ride.setStatus(RideStatus.ACCEPTED);

        return rideRepository.save(ride);
    }

    @Override
    public Ride startRide(Long rideId) {

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride Not Found"));

        ride.setStatus(RideStatus.STARTED);

        return rideRepository.save(ride);
    }

    @Override
    public Ride completeRide(Long rideId) {

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride Not Found"));

        ride.setStatus(RideStatus.COMPLETED);
        ride.setCompletedAt(LocalDateTime.now());

        return rideRepository.save(ride);
    }

    @Override
    public Ride cancelRide(Long rideId) {

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride Not Found"));

        ride.setStatus(RideStatus.CANCELLED);

        return rideRepository.save(ride);
    }
}