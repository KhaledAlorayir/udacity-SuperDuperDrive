package com.example.SuperDuperDrive.dto;

import com.example.SuperDuperDrive.entity.File;
import lombok.Data;

@Data
public class GetFileResponse {
    private int id;
    private String name;
    private String content_type;
    private String file_size;

    public GetFileResponse(File file) {
        this.id = file.getId();
        this.name = file.getName();
        this.content_type = file.getContent_type();
        this.file_size = file.getFile_size();
    }
}
