package com.example.gira.model.service;

import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.entity.enums.ClassificationNameEnum;

import java.time.LocalDate;

public class TaskServiceModel {

    private Long id;
    private String name;
    private String description;
    private LocalDate dueDate;
    private ClassificationNameEnum classification;
    private UserEntity user;

    public TaskServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public void setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
