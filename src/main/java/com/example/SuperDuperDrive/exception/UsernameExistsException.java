package com.example.SuperDuperDrive.exception;

public class UsernameExistsException extends RuntimeException {
    public UsernameExistsException() {
        super("username already exist");
    }
}
