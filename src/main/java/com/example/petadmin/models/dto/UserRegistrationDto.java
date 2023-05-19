package com.example.petadmin.models.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.petadmin.models.entity.user.Users} entity
 */
@Data
public class UserRegistrationDto implements Serializable {
    private final Long id;
    private final String email;
    private final String password;
}