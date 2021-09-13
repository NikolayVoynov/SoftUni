package com.example.db_spring_data_mvc_project.repository;

import com.example.db_spring_data_mvc_project.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    boolean existsAllBy();

}
