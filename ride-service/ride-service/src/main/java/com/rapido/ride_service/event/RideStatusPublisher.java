package com.rapido.ride_service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class RideStatusPublisher {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void publishStatus(
            Long rideId,
            RideStatusEvent event) {

        messagingTemplate.convertAndSend(
                "/topic/ride-status/" + rideId,
                event
        );
    }
}