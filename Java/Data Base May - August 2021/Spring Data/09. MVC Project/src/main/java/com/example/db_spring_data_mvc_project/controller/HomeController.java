package com.example.db_spring_data_mvc_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController extends BaseController {

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        if (this.isLogged(request)) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String home(HttpServletRequest request) {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }
        return "home";
    }
}
