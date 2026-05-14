package com.rapido.driverservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileDTO {

    private String fullName;

    private String email;

    private String phone;

    private String profileImage;
}