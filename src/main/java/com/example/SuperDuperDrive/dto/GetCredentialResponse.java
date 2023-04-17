package com.example.SuperDuperDrive.dto;

import com.example.SuperDuperDrive.entity.Credential;
import com.example.SuperDuperDrive.service.EncryptionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GetCredentialResponse {

    private int id;
    private String url;
    private String username;
    private String enc_password;
    private String  dec_password;


    public GetCredentialResponse(Credential credential, String dec_password) {
        this.id = credential.getId();
        this.url = credential.getUrl();
        this.username = credential.getUsername();
        this.enc_password = credential.getPassword();
        this.dec_password = dec_password;
    }

}
