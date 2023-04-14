package com.example.SuperDuperDrive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String homePage(){
        return "home";
    }

    @GetMapping("/")
    public String indexPage(){
        return "redirect:/home";
    }

}
