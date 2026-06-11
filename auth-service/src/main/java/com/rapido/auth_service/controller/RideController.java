package com.rapido.auth_service.controller;

import com.rapido.auth_service.dto.RideRequestedEvent;
import com.rapido.auth_service.kafka.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final KafkaProducerService kafkaProducerService;

    public RideController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/request")
    public String requestRide(@RequestBody RideRequestedEvent event) {

        kafkaProducerService.publishEvent(
                "ride-requested",
                event
        );

        return "Ride Request Event Published Successfully";
    }

}
