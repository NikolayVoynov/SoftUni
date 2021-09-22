package com.example.db_spring_data_mvc_project.repository;

import com.example.db_spring_data_mvc_project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findFirstByNameAndCompanyName(String name, String companyName);

    boolean existsAllBy();
}
