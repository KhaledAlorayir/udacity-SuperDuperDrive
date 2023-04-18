package com.example.SuperDuperDrive.exception;

import com.example.SuperDuperDrive.dto.ExceptionResponse;
import com.example.SuperDuperDrive.util.ErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdviceHandler {

    private final ErrorHandler errorHandler;

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(MaxUploadSizeExceededException exc, RedirectAttributes redirectAttrs) {
        return errorHandler.Handler("the file exceeds the allowed file size of 1mb", redirectAttrs);
    }

    @ExceptionHandler({FilenameExistsException.class, EmptyFileException.class, ResourceNotFoundException.class})
    public String handleUserExceptions(RuntimeException exception, RedirectAttributes redirectAttrs) {
        return errorHandler.Handler(exception.getMessage(), redirectAttrs);
    }

    @ExceptionHandler({UnauthorizedException.class})
    public String handleUnauthorizedException(RuntimeException exception, RedirectAttributes redirectAttrs) {
        return errorHandler.Handler(exception.getMessage(), redirectAttrs, "login");
    }

    @ExceptionHandler(UsernameExistsException.class)
    public String handleUnauthorizedUsernameExistsException(RuntimeException exception, RedirectAttributes redirectAttrs) {
        return errorHandler.Handler(exception.getMessage(), redirectAttrs, "signup");
    }

}
