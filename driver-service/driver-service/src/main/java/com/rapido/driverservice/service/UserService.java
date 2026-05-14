package com.rapido.driverservice.service;

import com.rapido.driverservice.dto.UserProfileDTO;

public interface UserService {

    UserProfileDTO getProfile(String email);

    void updateProfile(String email, UserProfileDTO dto);
}