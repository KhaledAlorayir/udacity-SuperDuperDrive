package com.example.SuperDuperDrive.service;

import com.example.SuperDuperDrive.dto.GetDownloadFileResponse;
import com.example.SuperDuperDrive.dto.GetFileResponse;
import com.example.SuperDuperDrive.dto.Response;
import com.example.SuperDuperDrive.entity.File;
import com.example.SuperDuperDrive.mapper.FileMapper;
import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileService {

    private final AuthService authService;
    private final FileMapper fileMapper;

    public Response createFile(MultipartFile multipartFile) {
        Optional<File> optionalFile = fileMapper.findByFilenameAndUserId(multipartFile.getOriginalFilename(), authService.getAuthentication().getId());

        if (optionalFile.isPresent()) {
            return new Response<Boolean>(false, "you have uploaded a file with the same name before!");
        }

        try {
            fileMapper.create(new File(multipartFile.getOriginalFilename(), multipartFile.getContentType(), String.valueOf(multipartFile.getSize()), authService.getAuthentication().getId(), multipartFile.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Response<Boolean>(true);
    }

    public List<GetFileResponse> getFiles() {
        return fileMapper.findAllByUserId(authService.getAuthentication().getId()).stream().map(file -> new GetFileResponse(file)).collect(Collectors.toList());
    }

    public GetDownloadFileResponse getFileData(int fileId) {
        File file = fileMapper.findById(fileId).orElseThrow(() -> new RuntimeException("file doesn't exist"));

        if (file.getUser_id() != authService.getAuthentication().getId()) {
            throw new RuntimeException("not authorized");
        }
        return new GetDownloadFileResponse(file);
    }

    public void deleteFile(int fileId) {
        File file = fileMapper.findById(fileId).orElseThrow(() -> new RuntimeException("file doesn't exist"));

        if (file.getUser_id() != authService.getAuthentication().getId()) {
            throw new RuntimeException("not authorized");
        }
        fileMapper.deleteById(fileId);
    }


}
