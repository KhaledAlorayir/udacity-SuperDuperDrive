package com.example.SuperDuperDrive.controller;

import com.example.SuperDuperDrive.dto.CreateUserRequest;
import com.example.SuperDuperDrive.entity.User;
import com.example.SuperDuperDrive.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;

    @GetMapping("/signup")
    public String signupPage(CreateUserRequest createUserRequest) {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupAction(CreateUserRequest createUserRequest) {
        userMapper.create(new User("s","s","s","s","s"));
        System.out.println(userMapper.getAll());
        return "signup";
    }


}
