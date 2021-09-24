package com.example.db_spring_data_mvc_project.repository;

import com.example.db_spring_data_mvc_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsAllBy();

    Employee findFirstByFirstNameAndLastNameAndAge(String firstName, String lastName, int age);

    List<Employee> findAllByAgeAfter(int age);
}
