package com.rapido.ride_service.tracker;

import com.rapido.ride_service.event.DriverLocationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class TrackingService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void processLocation(
            DriverLocationEvent event) {

        messagingTemplate.convertAndSend(
                "/topic/ride/" + event.getRideId(),
                event
        );
    }
}