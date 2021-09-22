package com.example.db_spring_data_mvc_project.service;

import com.example.db_spring_data_mvc_project.dto.CompanyDto;
import com.example.db_spring_data_mvc_project.entity.Company;

import java.io.IOException;

public interface CompanyService {

    public static final String FILE_PATH = "files/xmls/companies.xml";

    boolean exists();

    String getXmlForImport() throws IOException;

    Long create(CompanyDto request);

    Company find(Long id);
}
