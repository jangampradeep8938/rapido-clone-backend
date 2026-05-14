package com.rapido.driverservice.repository;

import com.rapido.driverservice.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByEmail(String email);

    List<Driver> findByAvailableTrueAndOnlineTrue();
}