package com.example.gira.model.view;

import com.example.gira.model.entity.ClassificationEntity;
import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.entity.enums.ProgressNameEnum;

import java.time.LocalDate;

public class TaskViewModel {

    private Long id;
    private String name;
    private String username;
    private ClassificationEntity classification;
    private LocalDate dueDate;
    private ProgressNameEnum progress;

    public TaskViewModel() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ClassificationEntity getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEntity classification) {
        this.classification = classification;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ProgressNameEnum getProgress() {
        return progress;
    }

    public void setProgress(ProgressNameEnum progress) {
        this.progress = progress;
    }
}
