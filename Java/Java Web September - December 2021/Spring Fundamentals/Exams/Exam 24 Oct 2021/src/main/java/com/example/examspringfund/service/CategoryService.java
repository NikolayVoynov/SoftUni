package com.example.examspringfund.service;

import com.example.examspringfund.model.entity.CategoryEntity;
import com.example.examspringfund.model.entity.CategoryNameEnum;

public interface CategoryService {

    void initCategories();


    CategoryEntity findByCategoryNameEnum(CategoryNameEnum category);
}
