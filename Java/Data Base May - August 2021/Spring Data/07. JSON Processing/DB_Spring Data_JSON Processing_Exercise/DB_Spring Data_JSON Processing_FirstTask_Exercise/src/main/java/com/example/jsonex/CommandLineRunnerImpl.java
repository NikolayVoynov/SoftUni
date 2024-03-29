package com.example.jsonex;

import com.example.jsonex.model.dto.CategoriesByProductsCountDto;
import com.example.jsonex.model.dto.ProductNameAndPriceDto;
import com.example.jsonex.model.dto.UserSoldDto;
import com.example.jsonex.service.CategoryService;
import com.example.jsonex.service.ProductService;
import com.example.jsonex.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final String OUTPUT_PATH = "src/main/resources/files/out/";
    private static final String PRODUCTS_IN_RANGE_FILE_NAME = "products-in-range.json";
    private static final String USERS_AND_SOLD_PRODUCTS = "users-and-sold-products.json";
    private static final String CATEGORIES_ORDERED_BY_PRODUCTS_COUNT = "categories-ordered-by-products-count.json";

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;
    private final Gson gson;

    public CommandLineRunnerImpl(CategoryService categoryService, UserService userService, ProductService productService, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Enter exercise number or 0 to exit program:");
        int exerciseNumber = Integer.parseInt(bufferedReader.readLine());

        while (exerciseNumber != 0) {

            switch (exerciseNumber) {
                case 1 -> productsInRange();
                case 2 -> soldProducts();
                case 3 -> categoriesByProductsCount();
                case 4 -> getUsersAndProducts();
            }

            System.out.println("Enter exercise number or 0 to exit program:");
            exerciseNumber = Integer.parseInt(bufferedReader.readLine());
        }

    }

    private void getUsersAndProducts() {
        productService.getUsersAndProducts();
    }

    private void categoriesByProductsCount() throws IOException {
        categoryService.findAllCategoriesOrderByNumberProducts();
    }

    private void soldProducts() throws IOException {
        List<UserSoldDto> userSoldDtos = userService
                .findAllUsersWithMoreThanOneSoldProducts();

        String content = gson.toJson(userSoldDtos);

        writeToFile(OUTPUT_PATH + USERS_AND_SOLD_PRODUCTS, content);
    }

    private void productsInRange() throws IOException {
        List<ProductNameAndPriceDto> productNameAndPriceDtoList =
                productService
                        .findAllProductsInRangeOrderByPrice(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));

        String content = gson.toJson(productNameAndPriceDtoList);

        writeToFile(OUTPUT_PATH + PRODUCTS_IN_RANGE_FILE_NAME, content);
    }

    private void writeToFile(String filePath, String content) throws IOException {
        Files
                .write(Path.of(filePath), Collections.singleton(content));
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productService.seedProduct();
    }
}
