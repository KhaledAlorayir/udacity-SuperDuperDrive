package com.example.SuperDuperDrive.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@NoArgsConstructor
public class File {
    private int id;
    private String name;
    private String content_type;
    private String file_size;
    private int user_id;
    private Blob file_data;
}
