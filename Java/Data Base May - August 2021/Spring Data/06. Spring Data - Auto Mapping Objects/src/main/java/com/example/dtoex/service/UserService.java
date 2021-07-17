package com.example.dtoex.service;

import com.example.dtoex.modul.dto.UserLoginDto;
import com.example.dtoex.modul.dto.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginService(UserLoginDto userLoginDto);

    void logoutUser();
}
