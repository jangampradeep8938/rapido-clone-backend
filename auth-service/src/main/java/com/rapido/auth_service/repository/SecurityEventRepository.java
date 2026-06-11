package com.rapido.auth_service.repository;

import com.rapido.auth_service.entity.SecurityEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityEventRepository
        extends JpaRepository<SecurityEvent, Long> {

    long countByEventType(String eventType);

}