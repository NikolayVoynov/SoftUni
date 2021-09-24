package com.example.db_spring_data_mvc_project.service;

import com.example.db_spring_data_mvc_project.dto.ExportedProjectDto;
import com.example.db_spring_data_mvc_project.dto.ProjectDto;
import com.example.db_spring_data_mvc_project.entity.Project;

import java.io.IOException;
import java.util.List;

public interface ProjectService {

    public static final String FILE_PATH = "files/xmls/projects.xml";

    boolean exists();

    String getXmlForImport() throws IOException;

    Long create(ProjectDto request);

    Project find(Long id);

    List<ExportedProjectDto> finishedProjects();
}
