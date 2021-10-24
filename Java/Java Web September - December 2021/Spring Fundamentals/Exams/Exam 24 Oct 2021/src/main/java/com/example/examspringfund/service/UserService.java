package com.example.examspringfund.service;

import com.example.examspringfund.model.entity.UserEntity;
import com.example.examspringfund.model.service.UserServiceModel;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    void loginUser(Long id, String username);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserEntity findById(Long id);
}
