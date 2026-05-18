package com.rapido.notification_service.service.impl;

import com.rapido.notification_service.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl
        implements EmailService {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    EmailServiceImpl.class
            );

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(
            String to,
            String subject,
            String body) {

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        logger.info(
                "Email Sent"
        );

        mailSender.send(message);
    }
}