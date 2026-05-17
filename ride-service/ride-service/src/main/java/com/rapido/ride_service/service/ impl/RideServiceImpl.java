package com.rapido.ride_service.service.impl;

import com.rapido.ride_service.dto.RideRequestDTO;
import com.rapido.ride_service.entity.Ride;
import com.rapido.ride_service.entity.RideStatus;
import com.rapido.ride_service.event.RideStatusEvent;
import com.rapido.ride_service.event.RideStatusPublisher;
import com.rapido.ride_service.repository.RideRepository;
import com.rapido.ride_service.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private RideStatusPublisher statusPublisher;

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

        Ride savedRide = rideRepository.save(ride);

        RideStatusEvent event = RideStatusEvent.builder()
                .rideId(savedRide.getId())
                .status(RideStatus.REQUESTED)
                .message("Ride Requested")
                .build();

        statusPublisher.publishStatus(
                savedRide.getId(),
                event
        );

        return savedRide;
    }

    @Override
    public Ride acceptRide(Long rideId) {

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride Not Found"));

        ride.setStatus(RideStatus.ACCEPTED);

        Ride savedRide = rideRepository.save(ride);

        RideStatusEvent event = RideStatusEvent.builder()
                .rideId(savedRide.getId())
                .status(RideStatus.ACCEPTED)
                .message("Ride Accepted")
                .build();

        statusPublisher.publishStatus(
                savedRide.getId(),
                event
        );

        return savedRide;
    }

    @Override
    public Ride startRide(Long rideId) {

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride Not Found"));

        ride.setStatus(RideStatus.STARTED);

        Ride savedRide = rideRepository.save(ride);

        RideStatusEvent event = RideStatusEvent.builder()
                .rideId(savedRide.getId())
                .status(RideStatus.STARTED)
                .message("Ride Started")
                .build();

        statusPublisher.publishStatus(
                savedRide.getId(),
                event
        );

        return savedRide;
    }

    @Override
    public Ride completeRide(Long rideId) {

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride Not Found"));

        ride.setStatus(RideStatus.COMPLETED);
        ride.setCompletedAt(LocalDateTime.now());

        Ride savedRide = rideRepository.save(ride);

        RideStatusEvent event = RideStatusEvent.builder()
                .rideId(savedRide.getId())
                .status(RideStatus.COMPLETED)
                .message("Ride Completed")
                .build();

        statusPublisher.publishStatus(
                savedRide.getId(),
                event
        );

        return savedRide;
    }

    @Override
    public Ride cancelRide(Long rideId) {

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride Not Found"));

        ride.setStatus(RideStatus.CANCELLED);

        Ride savedRide = rideRepository.save(ride);

        RideStatusEvent event = RideStatusEvent.builder()
                .rideId(savedRide.getId())
                .status(RideStatus.CANCELLED)
                .message("Ride Cancelled")
                .build();

        statusPublisher.publishStatus(
                savedRide.getId(),
                event
        );

        return savedRide;
    }
}