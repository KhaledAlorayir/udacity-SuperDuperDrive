package com.example.SuperDuperDrive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response<T> {
    private T data;
    private String error;

    public Response(T data) {
        this.data = data;
    }
}
