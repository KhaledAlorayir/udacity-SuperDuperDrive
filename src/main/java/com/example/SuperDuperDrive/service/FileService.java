package com.example.SuperDuperDrive.service;

import com.example.SuperDuperDrive.dto.GetDownloadFileResponse;
import com.example.SuperDuperDrive.dto.GetFileResponse;
import com.example.SuperDuperDrive.dto.ExceptionResponse;
import com.example.SuperDuperDrive.entity.File;
import com.example.SuperDuperDrive.exception.EmptyFileException;
import com.example.SuperDuperDrive.exception.FilenameExistsException;
import com.example.SuperDuperDrive.exception.ResourceNotFoundException;
import com.example.SuperDuperDrive.exception.UnauthorizedException;
import com.example.SuperDuperDrive.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileService {

    private final AuthService authService;
    private final FileMapper fileMapper;

    public void createFile(MultipartFile multipartFile) {

        if (multipartFile.isEmpty()) {
            throw new EmptyFileException();
        }

        Optional<File> optionalFile = fileMapper.findByFilenameAndUserId(multipartFile.getOriginalFilename(), authService.getAuthentication().getId());

        if (optionalFile.isPresent()) {
            throw new FilenameExistsException();
        }

        try {
            fileMapper.create(new File(multipartFile.getOriginalFilename(), multipartFile.getContentType(), String.valueOf(multipartFile.getSize()), authService.getAuthentication().getId(), multipartFile.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<GetFileResponse> getFiles() {
        return fileMapper.findAllByUserId(authService.getAuthentication().getId()).stream().map(file -> new GetFileResponse(file)).collect(Collectors.toList());
    }

    public GetDownloadFileResponse getFileData(int fileId) {
        File file = fileMapper.findById(fileId).orElseThrow(() -> new ResourceNotFoundException());

        if (file.getUser_id() != authService.getAuthentication().getId()) {
            throw new UnauthorizedException();
        }
        return new GetDownloadFileResponse(file);
    }

    public void deleteFile(int fileId) {
        File file = fileMapper.findById(fileId).orElseThrow(() -> new ResourceNotFoundException());

        if (file.getUser_id() != authService.getAuthentication().getId()) {
            throw new UnauthorizedException();
        }
        fileMapper.deleteById(fileId);
    }


}
