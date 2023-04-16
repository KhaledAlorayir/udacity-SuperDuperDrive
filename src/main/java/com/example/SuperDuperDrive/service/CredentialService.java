package com.example.SuperDuperDrive.service;

import com.example.SuperDuperDrive.dto.CreateCredentialRequest;
import com.example.SuperDuperDrive.dto.GetCredentialResponse;
import com.example.SuperDuperDrive.entity.Credential;
import com.example.SuperDuperDrive.mapper.CredentialMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<GetCredentialResponse> getCredentials() {
        return credentialMapper.findAllByUserId(authService.getAuthentication().getId()).stream().map(credential -> new GetCredentialResponse(credential)).collect(Collectors.toList());
    }

    public void deleteCredential(int credentialId) {
        Credential credential = credentialMapper.findById(credentialId).orElseThrow(() -> new RuntimeException("note doesn't exist"));

        if(credential.getUser_id() != authService.getAuthentication().getId()) {
            throw new RuntimeException("not authorized");
        }
        credentialMapper.deleteById(credentialId);
    }

}
