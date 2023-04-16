package com.example.SuperDuperDrive.service;

import com.example.SuperDuperDrive.dto.CreateCredentialRequest;
import com.example.SuperDuperDrive.entity.Credential;
import com.example.SuperDuperDrive.mapper.CredentialMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CredentialService {
    private final CredentialMapper credentialMapper;
    private final EncryptionService encryptionService;
    private final AuthService authService;

    public void createCredential(CreateCredentialRequest createCredentialRequest) {
        String key = encryptionService.generateKey();
        String encryptedPassword = encryptionService.encryptValue(createCredentialRequest.getPassword(),key);
        credentialMapper.create(new Credential(createCredentialRequest.getUrl(),createCredentialRequest.getUsername(),key,encryptedPassword,authService.getAuthentication().getId()));
    }

}
