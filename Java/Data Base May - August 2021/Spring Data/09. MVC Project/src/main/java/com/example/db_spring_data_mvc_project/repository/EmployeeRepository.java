package com.example.db_spring_data_mvc_project.repository;

import com.example.db_spring_data_mvc_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsAllBy();

}
