package com.example.auth_api.dtos;

import com.example.auth_api.entities.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
