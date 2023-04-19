package com.example.SuperDuperDrive.controller;

import com.example.SuperDuperDrive.dto.CreateCredentialRequest;
import com.example.SuperDuperDrive.dto.CreateNoteRequest;
import com.example.SuperDuperDrive.dto.FormValidationError;
import com.example.SuperDuperDrive.service.AuthService;
import com.example.SuperDuperDrive.service.CredentialService;
import com.example.SuperDuperDrive.service.FileService;
import com.example.SuperDuperDrive.service.NoteService;
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

    private final NoteService noteService;
    private final CredentialService credentialService;
    private final FileService fileService;

    @GetMapping("/")
    public String indexPage() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String homePage(CreateNoteRequest createNoteRequest, CreateCredentialRequest createCredentialRequest, Model model) {
        model.addAttribute("notes", noteService.getNotes());
        model.addAttribute("credentials", credentialService.getCredentials());
        model.addAttribute("files", fileService.getFiles());
        return "home";
    }

    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }


}
