package com.example.shopping_list.service;

import com.example.shopping_list.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);
}
