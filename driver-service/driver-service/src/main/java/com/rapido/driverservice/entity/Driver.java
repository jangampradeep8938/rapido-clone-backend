package com.rapido.driverservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String phone;

    private String vehicleNumber;

    private String vehicleModel;

    private String vehicleType;

    private Boolean available;

    private Boolean online;

    private Double currentLatitude;

    private Double currentLongitude;
}