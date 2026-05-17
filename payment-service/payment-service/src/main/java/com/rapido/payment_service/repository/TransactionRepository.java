package com.rapido.payment_service.repository;

import com.rapido.payment_service.entity.PaymentStatus;
import com.rapido.payment_service.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    boolean existsByRideIdAndStatus(
            Long rideId,
            PaymentStatus status
    );
}