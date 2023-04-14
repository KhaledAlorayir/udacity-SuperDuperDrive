package com.example.SuperDuperDrive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Response<T> {
    private T data;
    private String error;
}
