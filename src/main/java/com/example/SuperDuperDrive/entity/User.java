package com.example.SuperDuperDrive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String salt;
    private String password;
    private String firstname;
    private String lastname;

    public User(String username, String salt, String password, String firstname, String lastname) {
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
