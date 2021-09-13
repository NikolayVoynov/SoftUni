package com.example.db_spring_data_mvc_project.service.impl;

import com.example.db_spring_data_mvc_project.repository.CompanyRepository;
import com.example.db_spring_data_mvc_project.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public boolean exists() {
        return companyRepository.existsAllBy();
    }
}
