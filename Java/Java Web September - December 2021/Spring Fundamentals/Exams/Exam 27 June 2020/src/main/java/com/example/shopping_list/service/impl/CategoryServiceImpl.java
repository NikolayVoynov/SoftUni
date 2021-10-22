package com.example.shopping_list.service.impl;

import com.example.shopping_list.model.entity.CategoryEntity;
import com.example.shopping_list.model.entity.CategoryNameEnum;
import com.example.shopping_list.repository.CategoryRepository;
import com.example.shopping_list.service.CategoryService;
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
                    CategoryEntity categoryEntity = new CategoryEntity();
                    categoryEntity.setName(categoryNameEnum);

                    categoryRepository.save(categoryEntity);
                });

    }

    @Override
    public CategoryEntity findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
