package com.example.SuperDuperDrive.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CreateUserRequest {
    @NotBlank
    @Size(max = 20)
    private String firstname;
    @NotBlank
    @Size(max = 20)
    private String lastname;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 20)
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

    public void clear() {
        this.setFirstname("");
        this.setLastname("");
        this.setPassword("");
        this.setUsername("");
    }
}
