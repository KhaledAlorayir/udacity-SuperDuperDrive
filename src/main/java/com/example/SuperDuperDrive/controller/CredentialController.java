package com.example.SuperDuperDrive.controller;

import com.example.SuperDuperDrive.dto.CreateCredentialRequest;
import com.example.SuperDuperDrive.dto.FormValidationError;
import com.example.SuperDuperDrive.service.CredentialService;
import com.example.SuperDuperDrive.util.Helpers;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CredentialController {
    private final Helpers helpers;
    private final CredentialService credentialService;
    @PostMapping("/credentials")
    public String credentialFormAction(@Valid CreateCredentialRequest createCredentialRequest, BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            List<FormValidationError> formValidationErrors = helpers.getErrors(result);
            redirectAttrs.addFlashAttribute("formErrors", formValidationErrors);
            return "redirect:/home";
        }
        credentialService.createCredential(createCredentialRequest);
        return "redirect:/home";
    }

    @GetMapping("/credentials/{credentialId}/delete")
    public String deleteCredential(@PathVariable int credentialId) {
        credentialService.deleteCredential(credentialId);
        return "redirect:/home";
    }
}
