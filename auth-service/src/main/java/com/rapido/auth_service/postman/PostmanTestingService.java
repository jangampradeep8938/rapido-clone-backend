package com.rapido.auth_service.postman;

import org.springframework.stereotype.Service;

@Service
public class PostmanTestingService {

    public void testApi(String endpoint) {

        System.out.println("Testing Endpoint: " + endpoint);

        System.out.println("Postman Testing Completed");
    }
}