package com.example.dtoex.service.impl;

import com.example.dtoex.modul.dto.UserLoginDto;
import com.example.dtoex.modul.dto.UserRegisterDto;
import com.example.dtoex.modul.entity.User;
import com.example.dtoex.repository.UserRepository;
import com.example.dtoex.service.UserService;
import com.example.dtoex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            System.out.println("WRONG confirm password!");
            return;
        }

        Set<ConstraintViolation<UserRegisterDto>> violations = validationUtil.getViolations(userRegisterDto);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            return;
        }

        User user = modelMapper.map(userRegisterDto, User.class);
        userRepository.save(user);

        System.out.printf("%s was registered%n", user.getFullName());
    }

    @Override
    public void loginService(UserLoginDto userLoginDto) {
        Set<ConstraintViolation<UserLoginDto>> violations = validationUtil.getViolations(userLoginDto);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            return;
        }

        User user = userRepository
                .findByEmailAndPassword(userLoginDto.getEmail(),userLoginDto.getPassword())
                .orElse(null);

        if (user == null) {
            System.out.println("Incorrect username / password");
            return;
        }

        loggedInUser = user;

        System.out.printf("Successfully logged in %s%n", loggedInUser.getFullName());
    }

    @Override
    public void logoutUser() {
        String loggedOutUser = null;
        if (loggedInUser != null) {
            loggedOutUser = loggedInUser.getFullName();
        }

        if (loggedInUser == null) {
            System.out.println("Cannot log out. No user was logged in.");
            return;
        } else {
            loggedInUser = null;
        }

        System.out.printf("User %s successfully logged out%n", loggedOutUser);
    }
}
