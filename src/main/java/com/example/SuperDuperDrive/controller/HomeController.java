package com.example.SuperDuperDrive.controller;

import com.example.SuperDuperDrive.dto.CreateNoteRequest;
import com.example.SuperDuperDrive.dto.FormValidationError;
import com.example.SuperDuperDrive.service.AuthService;
import com.example.SuperDuperDrive.util.Helpers;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final Helpers helpers;

    @GetMapping("/home")
    public String homePage(CreateNoteRequest createNoteRequest){
        return "home";
    }

    @GetMapping("/")
    public String indexPage(){
        return "redirect:/home";
    }

    @PostMapping("/note")
    public String createNote(@Valid CreateNoteRequest createNoteRequest, BindingResult result, Model model) {
        if(result.hasErrors()){
            List<FormValidationError> formValidationErrors = helpers.getErrors(result);
            model.addAttribute("formErrors",formValidationErrors);
            return "/home";
        }
        System.out.println(createNoteRequest);
        return "/home";
    }

}
