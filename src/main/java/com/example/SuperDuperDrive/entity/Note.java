package com.example.SuperDuperDrive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Note {
    private int id;
    private String title;
    private String description;
    private int userId;

    public Note(String title, String description, int userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
    }
}
