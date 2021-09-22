package com.example.db_spring_data_mvc_project.service.impl;

import com.example.db_spring_data_mvc_project.dto.EmployeeDto;
import com.example.db_spring_data_mvc_project.entity.Employee;
import com.example.db_spring_data_mvc_project.repository.EmployeeRepository;
import com.example.db_spring_data_mvc_project.service.EmployeeService;
import com.example.db_spring_data_mvc_project.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectService projectService;
    private final ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ProjectService projectService, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.projectService = projectService;
        this.mapper = mapper;
    }

    @Override
    public boolean exists() {
        return this.employeeRepository.existsAllBy();
    }

    @Override
    public String getXmlForImport() throws IOException {
        return new String(
                this.getClass()
                        .getClassLoader()
                        .getResourceAsStream(FILE_PATH)
                        .readAllBytes(), StandardCharsets.UTF_8);
    }

    @Override
    public Long create(EmployeeDto request) {
        var existing = this.employeeRepository.findFirstByFirstNameAndLastNameAndAge(
                request.getFirstName(), request.getLastName(), request.getAge()
        );

        if (existing != null) {
            return existing.getId();
        }

        var employee = this.mapper.map(request, Employee.class);
        var projectId = this.projectService.create(request.getProject());
        var project = this.projectService.find(projectId);

        employee.setProject(project);

        this.employeeRepository.save(employee);

        return employee.getId();
    }
}
