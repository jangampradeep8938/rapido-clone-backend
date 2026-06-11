package com.rapido.auth_service.consumergroup;

import org.springframework.stereotype.Service;

@Service
public class ConsumerGroupService {

    public void processMessage(String message) {

        System.out.println("Consumer Group Processing: " + message);

    }
}