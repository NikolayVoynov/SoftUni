package com.example.xmlex;

import com.example.xmlex.model.dto.*;
import com.example.xmlex.service.CategoryService;
import com.example.xmlex.service.ProductService;
import com.example.xmlex.service.UserService;
import com.example.xmlex.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final String RESOURCE_FILE_PATH = "src/main/resources/files/";
    private static final String CATEGORIES_FILE_NAME = "categories.xml";
    private static final String USERS_FILE_NAME = "users.xml";
    private static final String PRODUCTS_FILE_NAME = "products.xml";

    private static final String OUTPUT_FILE_PATH = "out/";
    private static final String PRODUCTS_IN_RANGE_FILE_NAME = "products-in-range.xml";
    private static final String SOLD_PRODUCTS_FILE_NAME = "sold-products.xml";

    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader reader;

    public CommandLineRunnerImpl(XmlParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Select number of exercise or 0 to end program:");
        int exNum = Integer.parseInt(reader.readLine());

        while (exNum != 0) {
            switch (exNum) {
                case 1 -> productsInRange();
                case 2 -> usersWithSuccessfullySoldProducts();
            }

            System.out.println("Select number of exercise or 0 to end program:");
            exNum = Integer.parseInt(reader.readLine());
        }

    }

    private void usersWithSuccessfullySoldProducts() throws JAXBException {

        UserViewRootDto userViewRootDto = userService.findUsersWithMoreThanOneSoldProduct();

        xmlParser.writeToFile(RESOURCE_FILE_PATH + OUTPUT_FILE_PATH + SOLD_PRODUCTS_FILE_NAME, userViewRootDto);

    }

    private void productsInRange() throws JAXBException {
        ProductViewRootDto rootDto = productService.findProductInRangeWithoutBuyer();

        xmlParser.writeToFile(RESOURCE_FILE_PATH+OUTPUT_FILE_PATH+PRODUCTS_IN_RANGE_FILE_NAME, rootDto);

    }

    private void seedData() throws JAXBException, FileNotFoundException {
        if (categoryService.getEntityCount() == 0) {
            CategorySeedRootDto categorySeedRootDto =
                    xmlParser.fromFile(RESOURCE_FILE_PATH + CATEGORIES_FILE_NAME, CategorySeedRootDto.class);

            categoryService.seedCategories(categorySeedRootDto.getCategories());
        }


        if (userService.getCount() == 0) {
            UserSeedRootDto userSeedRootDto =
                    xmlParser.fromFile(RESOURCE_FILE_PATH + USERS_FILE_NAME, UserSeedRootDto.class);

            userService.seedUsers(userSeedRootDto.getUsers());
        }


        if (productService.getCount() == 0) {
            ProductSeedRootDto productSeedRootDto =
                    xmlParser.fromFile(RESOURCE_FILE_PATH + PRODUCTS_FILE_NAME, ProductSeedRootDto.class);

            productService.seedProducts(productSeedRootDto.getProducts());
        }


    }
}
