package com.example.db_spring_data_mvc_project.service.impl;

import com.example.db_spring_data_mvc_project.repository.ProjectRepository;
import com.example.db_spring_data_mvc_project.service.ProjectService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public boolean exists() {
        return projectRepository.existsAllBy();
    }

    @Override
    public String getXmlForImport() throws IOException {
        return new String(
                this.getClass()
                        .getClassLoader()
                        .getResourceAsStream(FILE_PATH)
                        .readAllBytes(), StandardCharsets.UTF_8);
    }
}
