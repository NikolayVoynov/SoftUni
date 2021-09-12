package com.example.db_spring_data_mvc_project.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralBeanConfig {

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}
