package com.example.dtoex.service;

import com.example.dtoex.modul.dto.UserLoginDto;
import com.example.dtoex.modul.dto.UserRegisterDto;
import com.example.dtoex.modul.entity.Game;

import java.io.IOException;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginService(UserLoginDto userLoginDto);

    void logoutUser();

    void printGamesBoughtByLoggedUser() throws IOException;

    void purchaseBook(String gameTitle);
}
