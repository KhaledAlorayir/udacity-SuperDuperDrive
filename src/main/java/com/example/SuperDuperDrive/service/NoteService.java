package com.example.SuperDuperDrive.service;

import com.example.SuperDuperDrive.dto.CreateNoteRequest;
import com.example.SuperDuperDrive.entity.Note;
import com.example.SuperDuperDrive.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final AuthService authService;
    private final NoteMapper noteMapper;

    public void createNote(CreateNoteRequest createNoteRequest) {
        noteMapper.create(new Note(createNoteRequest.getTitle(),createNoteRequest.getDescription(),authService.getAuthentication().getId()));
    }

    //GET LIST WITH DTO
}
