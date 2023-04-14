package com.example.SuperDuperDrive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenerateHashPassword {
    private String hashedPassword;
    private String salt;
}
