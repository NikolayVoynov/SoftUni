package com.example.shopping_list.service;

import com.example.shopping_list.model.entity.CategoryEntity;
import com.example.shopping_list.model.entity.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
