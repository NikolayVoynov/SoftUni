package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.ProgressNameEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class TaskEntity extends BaseEntity {

    private String name;
    private String description;
    private ProgressNameEnum progress;
    private LocalDate dueDate;
    private ClassificationEntity classification;
    private UserEntity user;

    public TaskEntity() {
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(unique = true, nullable = false)
    public ProgressNameEnum getProgress() {
        return progress;
    }

    public void setProgress(ProgressNameEnum progress) {
        this.progress = progress;
    }

    @Column(nullable = false)
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueData) {
        this.dueDate = dueData;
    }

    @ManyToOne
    public ClassificationEntity getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEntity classification) {
        this.classification = classification;
    }

    @ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
