package com.example.SuperDuperDrive.dto;

import com.example.SuperDuperDrive.entity.File;
import lombok.Data;
@Data
public class GetDownloadFileResponse {
    private String name;
    private byte[] file_data;

    public GetDownloadFileResponse(File file) {
        this.name = file.getName();
        this.file_data = file.getFile_data();
    }

}
