package com.example.SuperDuperDrive.entity;

import lombok.Data;

@Data
public class Credential {
    public Credential(String url, String username, String secret, String password, int user_id) {
        this.url = url;
        this.username = username;
        this.secret = secret;
        this.password = password;
        this.user_id = user_id;
    }
    private int id;
    private String url;
    private String username;
    private String secret;
    private String password;
    private int user_id;
}