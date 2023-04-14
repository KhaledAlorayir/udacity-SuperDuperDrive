package com.example.SuperDuperDrive.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Note {
    private int id;
    private String title;
    private String description;
    private int user_id;

}
