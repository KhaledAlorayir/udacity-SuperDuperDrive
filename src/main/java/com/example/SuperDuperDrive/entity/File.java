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
    private byte[] file_data;

    public File(String name, String content_type, String file_size, int user_id, byte[] file_data) {
        this.name = name;
        this.content_type = content_type;
        this.file_size = file_size;
        this.user_id = user_id;
        this.file_data = file_data;
    }
}
