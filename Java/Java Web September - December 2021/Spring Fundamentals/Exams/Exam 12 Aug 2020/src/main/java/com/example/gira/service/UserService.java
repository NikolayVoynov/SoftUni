package com.example.gira.service;

import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findEmailAndPassword(String email, String password);

    void loginUser(Long id, String username);

    UserEntity findById(Long id);
}
