package com.example.db_spring_data_mvc_project.repository;

import com.example.db_spring_data_mvc_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByUsername(String username);

    boolean existsByUsernameOrEmail(String username, String email);

}
