# EVENT ARCHITECTURE

## Overview

The Rapido Clone backend follows an event-driven architecture using Apache Kafka to enable asynchronous communication between microservices. The architecture is designed to improve scalability, resiliency, fault tolerance, and eventual consistency.

## Kafka Topics

### Ride Topics

* ride-requested
* ride-assigned
* ride-started
* ride-completed

### Payment Topics

* payment-initiated
* payment-success
* payment-failed

### Notification Topics

* notification-requested

### Driver Topics

* driver-status-updated

### Dead Letter Queue Topics

* ride-dlq
* payment-dlq
* notification-dlq

## Consumers

### Ride Service Group

Processes ride-related events.

### Payment Service Group

Processes payment-related events.

### Notification Service Group

Processes notification events.

## Saga Pattern

### Orchestration Flow

Ride Request
→ Driver Assignment
→ Payment Processing
→ Notification

### Choreography Flow

RideRequested
→ DriverAssigned
→ PaymentCompleted
→ RideConfirmed

## Compensation Logic

If payment fails:

* Release allocated driver
* Cancel ride request
* Send failure notification

## Retry Policy

* Maximum retries: 3
* Exponential backoff:

    * 1 second
    * 2 seconds
    * 4 seconds

## Dead Letter Queue Policy

Failed events are redirected to their respective DLQ topics for later investigation and replay.

## Event Replay

The system supports replay of failed or historical events through administrative operations.

## Monitoring

The following metrics should be monitored:

* Consumer lag
* Throughput
* Failed messages
* DLQ volume

## Security

The platform supports secure communication and authenticated access between services.

## Conclusion

This architecture provides a scalable and resilient foundation for enterprise-grade ride-booking systems.
