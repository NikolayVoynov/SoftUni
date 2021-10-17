package com.example.examprep.service;

import com.example.examprep.model.entity.CategoryEntity;
import com.example.examprep.model.entity.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
