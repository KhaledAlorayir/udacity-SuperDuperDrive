package com.example.SuperDuperDrive.exception;

import com.example.SuperDuperDrive.dto.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(MaxUploadSizeExceededException exc, RedirectAttributes redirectAttrs) {
        Response response = new Response<Boolean>(false,"the file exceeds the allowed file size of 1mb");
        redirectAttrs.addFlashAttribute("response",response);
        return "redirect:/home";
    }

}
