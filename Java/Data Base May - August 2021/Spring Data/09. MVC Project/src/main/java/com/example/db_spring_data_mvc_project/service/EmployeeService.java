package com.example.db_spring_data_mvc_project.service;

import com.example.db_spring_data_mvc_project.dto.EmployeeDto;
import com.example.db_spring_data_mvc_project.dto.ExportedEmployeeDto;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    public static final String FILE_PATH = "files/xmls/employees.xml";

    boolean exists();

    String getXmlForImport() throws IOException;

    Long create(EmployeeDto request);

    List<ExportedEmployeeDto> getEmployeesAfter25();
}
