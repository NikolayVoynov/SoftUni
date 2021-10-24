package com.example.examspringfund.service.impl;

import com.example.examspringfund.model.entity.CategoryEntity;
import com.example.examspringfund.model.entity.CategoryNameEnum;
import com.example.examspringfund.repository.CategoryRepository;
import com.example.examspringfund.service.CategoryService;
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

                    categoryRepository.save(category);
                });
    }

    @Override
    public CategoryEntity findByCategoryNameEnum(CategoryNameEnum category) {
        return categoryRepository.findByName(category).orElse(null);
    }

}
