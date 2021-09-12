package com.example.db_spring_data_mvc_project.service;

import com.example.db_spring_data_mvc_project.dto.UserLoginDto;
import com.example.db_spring_data_mvc_project.dto.UserRegisterDto;

public interface UserService {

    boolean register(UserRegisterDto userRegisterDto);

    Long validateUserLoginDetails(UserLoginDto user);

}
