package com.example.SuperDuperDrive.exception;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        super("you are unauthorized to perform this action");
    }
}
