package com.example.db_spring_data_mvc_project.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    protected boolean isLogged(HttpServletRequest request) {
        var userId = request.getSession().getAttribute("userId");

        return userId != null;
    }
}
