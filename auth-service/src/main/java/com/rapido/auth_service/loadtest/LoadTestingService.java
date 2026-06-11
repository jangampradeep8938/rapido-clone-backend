package com.rapido.auth_service.loadtest;

import org.springframework.stereotype.Service;

@Service
public class LoadTestingService {

    public void performLoadTest() {

        for (int i = 1; i <= 100; i++) {
            System.out.println("Processing Request " + i);
        }

        System.out.println("Load Testing Completed");
    }
}