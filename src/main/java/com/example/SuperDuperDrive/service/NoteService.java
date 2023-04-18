package com.example.SuperDuperDrive.service;

import com.example.SuperDuperDrive.dto.CreateNoteRequest;
import com.example.SuperDuperDrive.dto.GetNoteResponse;
import com.example.SuperDuperDrive.entity.Note;
import com.example.SuperDuperDrive.exception.ResourceNotFoundException;
import com.example.SuperDuperDrive.exception.UnauthorizedException;
import com.example.SuperDuperDrive.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final AuthService authService;
    private final NoteMapper noteMapper;

    public void createNote(CreateNoteRequest createNoteRequest) {
        noteMapper.create(new Note(createNoteRequest.getTitle(),createNoteRequest.getDescription(),authService.getAuthentication().getId()));
    }

    public List<GetNoteResponse> getNotes() {
        return noteMapper.findAllByUserId(authService.getAuthentication().getId()).stream().map(note -> new GetNoteResponse(note)).collect(Collectors.toList());
    }

    public void deleteNote(int noteId) {
        Note note = noteMapper.findById(noteId).orElseThrow(() -> new ResourceNotFoundException());

        if(note.getUser_id() != authService.getAuthentication().getId()) {
            throw new UnauthorizedException();
        }
        noteMapper.deleteById(noteId);
    }

    public void updateNote(CreateNoteRequest createNoteRequest) {
        Note note = noteMapper.findById(createNoteRequest.getId()).orElseThrow(() -> new ResourceNotFoundException());

        if(note.getUser_id() != authService.getAuthentication().getId()) {
            throw new UnauthorizedException();
        }
        noteMapper.updateById(createNoteRequest);
    }
}
