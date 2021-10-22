package com.example.shopping_list.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping()
    public String index() {

        return "index";
    }
}
