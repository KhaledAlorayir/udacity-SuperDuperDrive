package com.example.SuperDuperDrive.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("resource not found");
    }
}
