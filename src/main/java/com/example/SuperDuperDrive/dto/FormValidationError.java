package com.example.SuperDuperDrive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Data
@AllArgsConstructor
public class FormValidationError {
    private String field;
    private String error;

    public FormValidationError(ObjectError error) {
        FieldError fieldError = (FieldError) error;
        this.field = fieldError.getField();
        this.error = fieldError.getDefaultMessage();
    }

}
