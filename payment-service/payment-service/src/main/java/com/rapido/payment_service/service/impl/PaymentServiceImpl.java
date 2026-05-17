package com.rapido.payment_service.service.impl;

import com.rapido.payment_service.entity.PaymentStatus;
import com.rapido.payment_service.entity.Transaction;
import com.rapido.payment_service.entity.Wallet;
import com.rapido.payment_service.repository.TransactionRepository;
import com.rapido.payment_service.repository.WalletRepository;
import com.rapido.payment_service.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentServiceImpl
        implements PaymentService {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    PaymentServiceImpl.class
            );

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    @Transactional
    public void topUpWallet(
            String email,
            Double amount) {

        Wallet wallet = walletRepository
                .findByUserId(1L)
                .orElse(new Wallet());

        wallet.setUserId(1L);

        if (wallet.getBalance() == null) {
            wallet.setBalance(0.0);
        }

        wallet.setBalance(
                wallet.getBalance() + amount
        );

        wallet.setActive(true);

        logger.info("Wallet Recharged");

        walletRepository.save(wallet);
    }

    @Override
    public Double getBalance(String email) {

        Wallet wallet = walletRepository
                .findByUserId(1L)
                .orElseThrow(() ->
                        new RuntimeException("Wallet Not Found"));

        return wallet.getBalance();
    }

    @Override
    @Transactional
    public String processRidePayment(
            String email,
            Long rideId) {

        boolean alreadyPaid =
                transactionRepository
                        .existsByRideIdAndStatus(
                                rideId,
                                PaymentStatus.SUCCESS
                        );

        if (alreadyPaid) {

            logger.error(
                    "Duplicate Payment Attempt"
            );

            throw new RuntimeException(
                    "Duplicate Payment"
            );
        }

        Wallet wallet = walletRepository
                .findByUserId(1L)
                .orElseThrow(() ->
                        new RuntimeException("Wallet Not Found"));

        Double fare = 100.0;

        if (wallet.getBalance() < fare) {

            logger.error(
                    "Insufficient Balance"
            );

            throw new RuntimeException(
                    "Insufficient Balance"
            );
        }

        Random random = new Random();

        boolean paymentSuccess =
                random.nextBoolean();

        if (!paymentSuccess) {

            logger.error(
                    "Payment Failed"
            );

            throw new RuntimeException(
                    "Payment Failed"
            );
        }

        wallet.setBalance(
                wallet.getBalance() - fare
        );

        walletRepository.save(wallet);

        Transaction transaction =
                new Transaction();

        transaction.setRideId(rideId);
        transaction.setPayerId(1L);
        transaction.setDriverId(1L);
        transaction.setAmount(fare);

        transaction.setStatus(
                PaymentStatus.SUCCESS
        );

        transaction.setTransactionReference(
                UUID.randomUUID().toString()
        );

        transaction.setCreatedAt(
                LocalDateTime.now()
        );

        transactionRepository.save(transaction);

        logger.info("Payment Successful");

        return "Payment Successful";
    }

    @Override
    @Transactional
    public String refundRide(Long rideId) {

        logger.info("Refund Processed");

        return "Refund Processed";
    }
}