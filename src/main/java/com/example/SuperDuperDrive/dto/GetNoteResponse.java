package com.example.SuperDuperDrive.dto;

import com.example.SuperDuperDrive.entity.Note;
import lombok.Data;


public class GetNoteResponse {
    private int id;
    private String title;
    private String description;

    public GetNoteResponse(Note note){
        this.id = note.getId();
        this.title = note.getTitle();
        this.description = note.getDescription();
    }

}
