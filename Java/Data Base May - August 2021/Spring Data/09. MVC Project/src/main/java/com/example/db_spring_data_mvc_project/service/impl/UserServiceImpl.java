package com.example.db_spring_data_mvc_project.service.impl;

import com.example.db_spring_data_mvc_project.dto.UserLoginDto;
import com.example.db_spring_data_mvc_project.dto.UserRegisterDto;
import com.example.db_spring_data_mvc_project.entity.User;
import com.example.db_spring_data_mvc_project.repository.UserRepository;
import com.example.db_spring_data_mvc_project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserRegisterDto userRequest) {

        if (this.userRepository.existsByUsernameOrEmail(
                userRequest.getUsername(), userRequest.getEmail())) {
            return false;
        }

        if (!userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
            return false;
        }

        var user = this.modelMapper.map(userRequest, User.class);
        this.userRepository.save(user);

        return true;
    }

    @Override
    public Long validateUserLoginDetails(UserLoginDto userRequest) {
        var user = this.userRepository.findFirstByUsername(userRequest.getUsername());

        if (user == null) {
            return null;
        }

        if (!user.getPassword().equals(userRequest.getPassword())) {
            return null;
        }

        return user.getId();
    }

}
