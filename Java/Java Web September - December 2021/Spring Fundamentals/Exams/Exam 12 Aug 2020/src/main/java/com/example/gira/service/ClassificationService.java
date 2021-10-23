package com.example.gira.service;

import com.example.gira.model.entity.ClassificationEntity;
import com.example.gira.model.entity.enums.ClassificationNameEnum;

public interface ClassificationService {
    void initCategories();

    ClassificationEntity findByClassificationNameEnum(ClassificationNameEnum classificationNameEnum);
}
