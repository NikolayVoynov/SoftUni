package com.example.examprep.service.impl;

import com.example.examprep.model.entity.CategoryEntity;
import com.example.examprep.model.entity.CategoryNameEnum;
import com.example.examprep.repository.CategoryRepository;
import com.example.examprep.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    CategoryEntity category = new CategoryEntity();
                    category.setName(categoryNameEnum);
                    switch (categoryNameEnum){
                        case DRINK -> category.setNeededTime(1);
                        case COFFEE -> category.setNeededTime(2);
                        case OTHER -> category.setNeededTime(5);
                        case CAKE -> category.setNeededTime(10);
                    }

                    categoryRepository.save(category);
                });
    }

    @Override
    public CategoryEntity findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {

        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
