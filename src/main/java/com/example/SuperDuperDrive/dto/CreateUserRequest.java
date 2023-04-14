package com.example.SuperDuperDrive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CreateUserRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    public void setFirstname(String firstname) {
        this.firstname = firstname.trim();
    }

    public void setLastname(String lastname) {
        this.lastname = lastname.trim();
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }
}
