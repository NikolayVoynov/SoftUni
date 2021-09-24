package com.example.db_spring_data_mvc_project.controller;

import com.example.db_spring_data_mvc_project.dto.*;
import com.example.db_spring_data_mvc_project.service.CompanyService;
import com.example.db_spring_data_mvc_project.service.EmployeeService;
import com.example.db_spring_data_mvc_project.service.ProjectService;
import com.example.db_spring_data_mvc_project.service.util.XmlConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ImportController extends BaseController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;
    private final ProjectService projectService;
    private final XmlConverter converter;

    public ImportController(EmployeeService employeeService, CompanyService companyService,
                            ProjectService projectService, XmlConverter converter) {
        this.employeeService = employeeService;
        this.companyService = companyService;
        this.projectService = projectService;

        this.converter = converter;
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
    public String importCompanies(Model model, HttpServletRequest request) throws IOException {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute(
                "companies",
                this.companyService.getXmlForImport()
        );

        return "xml/import-companies";
    }

    @PostMapping("/import/companies")
    public String importCompanies(ImportCompaniesDto request) {
        var companyRoot = this.converter.deserialize(
                request.getCompanies(),
                CompanyCollectionDto.class
        );

        companyRoot.getCompanies().forEach(this.companyService::create);

        return "redirect:/xml/import/xml";
    }

    @GetMapping("/import/employees")
    public String importEmployees(Model model, HttpServletRequest request) throws IOException {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute(
                "employees",
                this.employeeService.getXmlForImport()
        );

        return "xml/import-employees";

    }

    @PostMapping("/import/employees")
    public String importEmployees(ImportEmployeesDto request) {
        var employeeRoot = this.converter.deserialize(
                request.getEmployees(),
                EmployeeCollectionDto.class
        );

        employeeRoot.getEmployees().forEach(this.employeeService::create);

        return "redirect:/xml/import/xml";
    }

    @GetMapping("/import/projects")
    public String importProjects(Model model, HttpServletRequest request) throws IOException {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute(
                "projects",
                this.projectService.getXmlForImport()
        );

        return "xml/import-projects";
    }

    @PostMapping("/import/projects")
    public String importProjects(ImportProjectsDto request) {
        var projectRoot = this.converter.deserialize(
                request.getProjects(),
                ProjectCollectionDto.class
        );

        projectRoot.getProjects().forEach(this.projectService::create);

        return "redirect:/xml/import/xml";
    }
}
