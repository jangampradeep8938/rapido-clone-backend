package com.rapido.auth_service.monitoring;

import org.springframework.stereotype.Service;

@Service
public class KafkaMonitoringService {

    public void monitorKafka() {

        System.out.println("Kafka Monitoring Started");

        System.out.println("Monitoring Topics");

        System.out.println("Monitoring Consumers");

        System.out.println("Monitoring Producers");

        System.out.println("Kafka Monitoring Completed");
    }
}