package com.example.auth_api.entities;

public enum UserRole {
    ADMIN("admin"),
    COMMON("common");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
