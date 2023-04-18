package com.example.SuperDuperDrive.util;

import com.example.SuperDuperDrive.dto.ExceptionResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class ErrorHandler {

    public String Handler(String errorMessage, RedirectAttributes redirectAttrs) {
        ExceptionResponse response = new ExceptionResponse(errorMessage);
        redirectAttrs.addFlashAttribute("response",response);
        return "redirect:/home";
    }

    public String Handler(String errorMessage, RedirectAttributes redirectAttrs, String endpoint) {
        ExceptionResponse response = new ExceptionResponse(errorMessage);
        redirectAttrs.addFlashAttribute("response",response);
        return String.format("redirect:/%s",endpoint);
    }

}
