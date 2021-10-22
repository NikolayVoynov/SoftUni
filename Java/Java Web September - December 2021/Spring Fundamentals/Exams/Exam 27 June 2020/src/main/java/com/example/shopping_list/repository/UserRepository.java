package com.example.shopping_list.repository;

import com.example.shopping_list.model.entity.UserEntity;
import com.example.shopping_list.model.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
}
