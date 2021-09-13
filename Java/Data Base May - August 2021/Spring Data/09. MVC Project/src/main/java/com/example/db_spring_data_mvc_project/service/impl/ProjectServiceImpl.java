package com.example.db_spring_data_mvc_project.service.impl;

import com.example.db_spring_data_mvc_project.repository.ProjectRepository;
import com.example.db_spring_data_mvc_project.service.ProjectService;
import org.springframework.stereotype.Service;

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
}
