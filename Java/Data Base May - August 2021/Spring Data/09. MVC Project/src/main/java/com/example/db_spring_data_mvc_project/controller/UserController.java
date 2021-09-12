package com.example.db_spring_data_mvc_project.controller;

import com.example.db_spring_data_mvc_project.dto.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/users/register")
    public String register() {
        return "user/register";
    }

    @PostMapping("/users/register")
    public String register(UserRegisterDto userRegisterDto) {
        return "user/register";
    }
}
