package com.example.db_spring_data_mvc_project.service.impl;

import com.example.db_spring_data_mvc_project.repository.EmployeeRepository;
import com.example.db_spring_data_mvc_project.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
}
