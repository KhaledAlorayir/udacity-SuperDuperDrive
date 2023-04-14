package com.example.SuperDuperDrive.util;

import com.example.SuperDuperDrive.dto.FormValidationError;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Helpers {

    public List<FormValidationError> getErrors(BindingResult result) {
        return result.getAllErrors().stream().map(err -> new FormValidationError(err)).collect(Collectors.toList());
    }

}
