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
    private int user_id;

    public Note(String title, String description, int user_id) {
        this.title = title;
        this.description = description;
        this.user_id = user_id;
    }
}
