package com.example.db_spring_data_mvc_project.controller;

import com.example.db_spring_data_mvc_project.service.CompanyService;
import com.example.db_spring_data_mvc_project.service.EmployeeService;
import com.example.db_spring_data_mvc_project.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController extends BaseController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;
    private final ProjectService projectService;

    public HomeController(EmployeeService employeeService, CompanyService companyService,
                          ProjectService projectService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
        this.projectService = projectService;
    }


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
