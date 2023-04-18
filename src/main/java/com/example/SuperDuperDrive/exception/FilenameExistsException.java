package com.example.SuperDuperDrive.exception;

public class FilenameExistsException extends RuntimeException {

    public FilenameExistsException() {
        super("you have uploaded a file with the same name before!");
    }

}
