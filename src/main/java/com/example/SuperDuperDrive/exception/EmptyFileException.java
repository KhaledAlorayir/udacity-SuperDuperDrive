package com.example.SuperDuperDrive.exception;

public class EmptyFileException extends RuntimeException {
    public EmptyFileException() {
        super("please select a file!");
    }
}
