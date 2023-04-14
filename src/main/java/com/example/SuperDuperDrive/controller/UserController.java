package com.example.SuperDuperDrive.controller;

import com.example.SuperDuperDrive.dto.CreateUserRequest;
import com.example.SuperDuperDrive.dto.Response;

import com.example.SuperDuperDrive.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signupPage(CreateUserRequest createUserRequest) {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupAction(@Valid CreateUserRequest createUserRequest,BindingResult result, Model model) {
        if(result.hasErrors()){
            return "signup";
        }

        Response response = userService.createUser(createUserRequest);
        model.addAttribute("response",response);
        createUserRequest.clear();
        return "signup";
    }


}
