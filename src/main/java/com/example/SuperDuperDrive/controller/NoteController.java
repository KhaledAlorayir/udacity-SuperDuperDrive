package com.example.SuperDuperDrive.controller;

import com.example.SuperDuperDrive.dto.CreateNoteRequest;
import com.example.SuperDuperDrive.dto.FormValidationError;
import com.example.SuperDuperDrive.service.NoteService;
import com.example.SuperDuperDrive.util.Helpers;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoteController {

    private final Helpers helpers;
    private final NoteService noteService;

    @PostMapping("/notes")
    public String noteFormAction(@Valid CreateNoteRequest createNoteRequest, BindingResult result, Model model, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            List<FormValidationError> formValidationErrors = helpers.getErrors(result);
            redirectAttrs.addFlashAttribute("formErrors", formValidationErrors);
            return "redirect:/home";
        }

        if (createNoteRequest.getId() == null) {
            noteService.createNote(createNoteRequest);
            return "redirect:/home?note=created";
        } else {
            noteService.updateNote(createNoteRequest);
            return "redirect:/home?note=updated";
        }
    }

    @GetMapping("/notes/{noteId}/delete")
    public String deleteNote(@PathVariable int noteId) {
        noteService.deleteNote(noteId);
        return "redirect:/home?note=deleted";
    }
}
