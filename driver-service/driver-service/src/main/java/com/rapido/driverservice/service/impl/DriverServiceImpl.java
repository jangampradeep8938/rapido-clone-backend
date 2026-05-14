package com.rapido.driverservice.service.impl;

import com.rapido.driverservice.dto.DriverProfileDTO;
import com.rapido.driverservice.entity.Driver;
import com.rapido.driverservice.repository.DriverRepository;
import com.rapido.driverservice.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Override
    public DriverProfileDTO getProfile(String email) {

        Driver driver = driverRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Driver Not Found"));

        DriverProfileDTO dto = new DriverProfileDTO();

        dto.setFullName(driver.getFullName());
        dto.setPhone(driver.getPhone());
        dto.setVehicleNumber(driver.getVehicleNumber());
        dto.setVehicleModel(driver.getVehicleModel());
        dto.setVehicleType(driver.getVehicleType());

        return dto;
    }

    @Override
    public void updateAvailability(String email, Boolean available) {

        Driver driver = driverRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Driver Not Found"));

        driver.setAvailable(available);

        driverRepository.save(driver);
    }

    @Override
    public void updateOnlineStatus(String email, Boolean online) {

        Driver driver = driverRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Driver Not Found"));

        driver.setOnline(online);

        driverRepository.save(driver);
    }

    @Override
    public void updateLocation(
            String email,
            Double latitude,
            Double longitude) {

        Driver driver = driverRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Driver Not Found"));

        driver.setCurrentLatitude(latitude);
        driver.setCurrentLongitude(longitude);

        driverRepository.save(driver);
    }
}