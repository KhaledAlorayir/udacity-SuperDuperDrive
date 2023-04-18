package com.example.SuperDuperDrive.controller;

import com.example.SuperDuperDrive.dto.GetDownloadFileResponse;
import com.example.SuperDuperDrive.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/files")
    public String fileFormAction(@RequestParam("fileUpload") MultipartFile fileUpload) {
        fileService.createFile(fileUpload);
        return "redirect:/home?file=created";
    }

    @GetMapping("/files/{fileId}/delete")
    public String deleteFile(@PathVariable int fileId) {
        fileService.deleteFile(fileId);
        return "redirect:/home?file=deleted";
    }

    @GetMapping("/files/{fileId}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable int fileId) {
        GetDownloadFileResponse fileResponse = fileService.getFileData(fileId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileResponse.getName() + "\"")
                .body(fileService.getFileData(fileId).getFile_data());
    }

}
