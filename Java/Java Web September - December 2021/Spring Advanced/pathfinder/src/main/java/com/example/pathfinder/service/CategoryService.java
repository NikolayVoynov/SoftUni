package com.example.pathfinder.service;

import com.example.pathfinder.model.entity.CategoryEntity;

public interface CategoryService {

    CategoryEntity findCategoryByName(com.example.pathfinder.model.entity.enums.CategoryNameEnum categoryNameEnum);
}
