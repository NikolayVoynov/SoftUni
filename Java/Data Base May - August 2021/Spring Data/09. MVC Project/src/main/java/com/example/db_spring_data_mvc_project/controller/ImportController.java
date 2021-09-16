package com.example.db_spring_data_mvc_project.controller;

import com.example.db_spring_data_mvc_project.service.CompanyService;
import com.example.db_spring_data_mvc_project.service.EmployeeService;
import com.example.db_spring_data_mvc_project.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ImportController extends BaseController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;
    private final ProjectService projectService;

    public ImportController(EmployeeService employeeService, CompanyService companyService,
                            ProjectService projectService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
        this.projectService = projectService;
    }

    @GetMapping("/import/xml")
    public String importXml(Model model, HttpServletRequest request) {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute("areImported",
                new boolean[]{this.companyService.exists(), this.projectService.exists(), this.employeeService.exists()});

        return "xml/import-xml";
    }

    @GetMapping("/import/companies")
    public String importCompanies(Model model, HttpServletRequest request){
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        return "xml/import-companies";

    }

    @GetMapping("/import/employees")
    public String importEmployees(Model model, HttpServletRequest request){
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        return "xml/import-employees";

    }

    @GetMapping("/import/projects")
    public String importProjects(Model model, HttpServletRequest request){
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        return "xml/import-projects";

    }
}
