package com.rapido.driverservice.service.impl;

import com.rapido.driverservice.dto.UserProfileDTO;
import com.rapido.driverservice.entity.User;
import com.rapido.driverservice.repository.UserRepository;
import com.rapido.driverservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserProfileDTO getProfile(String email) {

        User user = userRepository.findByEmail(email).orElse(null);

        UserProfileDTO dto = new UserProfileDTO();

        if (user != null) {
            dto.setFullName(user.getFullName());
            dto.setEmail(user.getEmail());
            dto.setPhone(user.getPhone());
            dto.setProfileImage(user.getProfileImage());
        }

        return dto;
    }

    @Override
    public void updateProfile(String email, UserProfileDTO dto) {

        User user = userRepository.findByEmail(email).orElse(null);

        if (user != null) {
            user.setFullName(dto.getFullName());
            user.setPhone(dto.getPhone());
            user.setProfileImage(dto.getProfileImage());

            userRepository.save(user);
        }
    }
}