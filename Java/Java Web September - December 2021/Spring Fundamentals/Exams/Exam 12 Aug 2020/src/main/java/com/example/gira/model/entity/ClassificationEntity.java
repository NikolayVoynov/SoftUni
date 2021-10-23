package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.ClassificationNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class ClassificationEntity extends BaseEntity{

    private ClassificationNameEnum name;
    private String description;


    public ClassificationEntity() {
    }

    @Column(unique = true, nullable = false)
    @Enumerated(value = EnumType.STRING)
    public ClassificationNameEnum getName() {
        return name;
    }

    public void setName(ClassificationNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
