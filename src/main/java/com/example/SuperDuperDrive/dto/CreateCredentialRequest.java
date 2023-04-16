package com.example.SuperDuperDrive.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class CreateCredentialRequest {
    @NotBlank
    @URL
    @Size(max = 100)
    private String url;
    @NotBlank
    @Size(max = 30)
    private String username;
    @NotBlank
    @Size(max = 30)
    private String password;
}
