package com.rapido.auth_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    
    @KafkaListener(
            topics = "ride-requested",
            groupId = "auth-service-group"
    )
    public void consumeRideRequest(String message) {

        System.out.println("Event Consumed from Kafka");
        System.out.println("Message: " + message);
    }

}
