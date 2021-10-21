package com.example.music_db.service;

import com.example.music_db.model.entity.UserEntity;
import com.example.music_db.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    UserEntity findById(Long id);
}
