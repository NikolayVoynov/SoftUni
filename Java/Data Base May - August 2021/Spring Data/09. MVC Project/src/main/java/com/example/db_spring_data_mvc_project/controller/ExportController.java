package com.example.db_spring_data_mvc_project.controller;

import com.example.db_spring_data_mvc_project.service.ProjectService;
import com.example.db_spring_data_mvc_project.service.util.XmlConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/export")
public class ExportController {

    private final ProjectService projectService;
    private final XmlConverter converter;

    public ExportController(ProjectService projectService, XmlConverter xmlConverter) {
        this.projectService = projectService;
        this.converter = xmlConverter;
    }

    @GetMapping("/project-if-finished")
    public String finishedProjects(Model model) {
        model.addAttribute(
                "projectsIfFinished",
                this.projectService.finishedProjects().stream().map(this.converter::serialize)
                        .collect(Collectors.joining("\n"))
        );

        return "export/export-project-if-finished";
    }
}
