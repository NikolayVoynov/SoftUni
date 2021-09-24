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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/import")
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

    @GetMapping("/xml")
    public String importXml(Model model, HttpServletRequest request) {
        if (!this.isLogged(request)) {
            return "redirect:/";
        }

        model.addAttribute("areImported",
                new boolean[]{this.companyService.exists(), this.projectService.exists(), this.employeeService.exists()});

        return "xml/import-xml";
    }

    @GetMapping("/companies")
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

    @PostMapping("/companies")
    public String importCompanies(ImportCompaniesDto dto, HttpServletRequest req) {
        if (!this.isLogged(req)) {
            return "redirect:/";
        }

        var companyRoot = this.converter.deserialize(
                dto.getCompanies(),
                CompanyCollectionDto.class
        );

        companyRoot.getCompanies().forEach(this.companyService::create);

        return "redirect:/xml/import/xml";
    }

    @GetMapping("/employees")
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

    @PostMapping("/employees")
    public String importEmployees(ImportEmployeesDto dto, HttpServletRequest req) {
        if (!this.isLogged(req)) {
            return "redirect:/";
        }

        var employeeRoot = this.converter.deserialize(
                dto.getEmployees(),
                EmployeeCollectionDto.class
        );

        employeeRoot.getEmployees().forEach(this.employeeService::create);

        return "redirect:/xml/import/xml";
    }

    @GetMapping("/projects")
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

    @PostMapping("/projects")
    public String importProjects(ImportProjectsDto dto, HttpServletRequest req) {
        if (!this.isLogged(req)) {
            return "redirect:/";
        }

        var projectRoot = this.converter.deserialize(
                dto.getProjects(),
                ProjectCollectionDto.class
        );

        projectRoot.getProjects().forEach(this.projectService::create);

        return "redirect:/xml/import/xml";
    }
}
