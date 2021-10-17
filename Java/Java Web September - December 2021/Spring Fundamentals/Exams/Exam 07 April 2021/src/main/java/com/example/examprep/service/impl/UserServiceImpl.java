package com.example.examprep.service.impl;

import com.example.examprep.model.entity.UserEntity;
import com.example.examprep.model.service.UserServiceModel;
import com.example.examprep.repository.UserRepository;
import com.example.examprep.service.UserService;
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
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);

        return modelMapper.map(userRepository.save(userEntity), UserServiceModel.class);
    }
}
