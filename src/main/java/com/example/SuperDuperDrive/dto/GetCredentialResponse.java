package com.example.SuperDuperDrive.dto;

import com.example.SuperDuperDrive.entity.Credential;
import lombok.Data;

@Data
public class GetCredentialResponse {

    private int id;
    private String url;
    private String username;
    private String password;

    public GetCredentialResponse(Credential credential) {
        this.id = credential.getId();
        this.url = credential.getUrl();
        this.username = credential.getUsername();
        this.password = credential.getPassword();
    }

}
