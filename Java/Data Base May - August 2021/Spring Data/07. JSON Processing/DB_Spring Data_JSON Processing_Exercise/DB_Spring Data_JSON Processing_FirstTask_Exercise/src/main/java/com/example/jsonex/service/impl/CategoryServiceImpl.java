package com.example.jsonex.service.impl;

import com.example.jsonex.constants.GlobalConstants;
import com.example.jsonex.model.dto.CategoriesByProductsCountDto;
import com.example.jsonex.model.dto.CategorySeedDto;
import com.example.jsonex.model.entity.Category;
import com.example.jsonex.model.entity.Product;
import com.example.jsonex.repository.CategoryRepository;
import com.example.jsonex.service.CategoryService;
import com.example.jsonex.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_NAME = "categories.json";

    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws IOException {

        if (categoryRepository.count() > 0) {
            return;
        }

        String fileContent = Files
                .readString(Path.of(GlobalConstants.RESOURCES_FILE_PATH + CATEGORIES_FILE_NAME));

        CategorySeedDto[] categorySeedDtos = gson
                .fromJson(fileContent, CategorySeedDto[].class);

        Arrays.stream(categorySeedDtos)
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);

    }

    @Override
    public Set<Category> findRandomCategories() {
        Set<Category> categorySet = new HashSet<>();
        int categoryCount = ThreadLocalRandom.current().nextInt(1, 3);
        long totalCategoriesCount = categoryRepository.count();

        for (int i = 0; i < categoryCount; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, totalCategoriesCount + 1);

            categorySet.add(categoryRepository.findById(randomId).orElse(null));
        }
        return categorySet;
    }

    @Override
    public void findAllCategoriesOrderByNumberProducts() {
        List<Object[]> categoriesCount = categoryRepository.getCategoriesCount();

        List<CategoriesByProductsCountDto> categoriesByProductsCountDtoList = new ArrayList<>();
        for (Object[] objects : categoriesCount) {
            String category = (String) objects[0];
            long countProducts = (long) objects[1];
            BigDecimal averagePrice = new BigDecimal(objects[2].toString());
            BigDecimal totalPrice = new BigDecimal(objects[3].toString());

            CategoriesByProductsCountDto categoriesByProductsCountDto =
                    new CategoriesByProductsCountDto(category, (int) countProducts, averagePrice, totalPrice);
            categoriesByProductsCountDtoList.add(categoriesByProductsCountDto);
        }

        System.out.println(gson.toJson(categoriesByProductsCountDtoList));
    }
}
