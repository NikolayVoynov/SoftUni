package com.example.jsonex.service.impl;

import com.example.jsonex.constants.GlobalConstants;
import com.example.jsonex.model.dto.*;
import com.example.jsonex.model.entity.Product;
import com.example.jsonex.repository.ProductRepository;
import com.example.jsonex.service.CategoryService;
import com.example.jsonex.service.ProductService;
import com.example.jsonex.service.UserService;
import com.example.jsonex.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCTS_FILE_NAME = "products.json";

    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, Gson gson,
                              ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedProduct() throws IOException {

        if (productRepository.count() > 0) {
            return;
        }

        String fileContent = Files
                .readString(Path.of(GlobalConstants.RESOURCES_FILE_PATH + PRODUCTS_FILE_NAME));

        ProductSeedDto[] productSeedDtos = gson
                .fromJson(fileContent, ProductSeedDto[].class);

        Arrays.stream(productSeedDtos)
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);
                    product.setSeller(userService.findRandomUser());

//                        Condition for buyer is made by us (1:57:00)
                    if (product.getPrice().compareTo(BigDecimal.valueOf(900L)) > 0) {
                        product.setBuyer(userService.findRandomUser());
                    }

                    product.setCategories(categoryService.findRandomCategories());

                    return product;
                })
                .forEach(productRepository::save);


    }

    @Override
    public List<ProductNameAndPriceDto> findAllProductsInRangeOrderByPrice(BigDecimal lower, BigDecimal upper) {
        return productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(lower, upper)
                .stream()
                .map(product -> {
                    ProductNameAndPriceDto productNameAndPriceDto = modelMapper.map(product, ProductNameAndPriceDto.class);

                    productNameAndPriceDto.setSeller(String.format("%s %s",
                            product.getSeller().getFirstName(), product.getSeller().getLastName()));

                    return productNameAndPriceDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void getUsersAndProducts() {
        UsersCountDto usersCountDto = new UsersCountDto();

        Map<Long, SellerProductsDto> sellerProductsDtoMap = new LinkedHashMap<>();
        Map<Long, List<SoldProductDataDto>> soldProductDataDtoMap = new LinkedHashMap<>();

        productRepository.findAllByBuyerIsNotNull()
                .forEach(product -> {
                    SellerProductsDto sellerProductsDto = modelMapper.map(product, SellerProductsDto.class);
                    SoldProductDataDto soldProductDataDto = modelMapper.map(product, SoldProductDataDto.class);

                    sellerProductsDtoMap.putIfAbsent(product.getSeller().getId(), sellerProductsDto);
                    soldProductDataDtoMap.putIfAbsent(product.getSeller().getId(), new ArrayList<>());
                    soldProductDataDtoMap.get(product.getSeller().getId()).add(soldProductDataDto);
                });

        for (Map.Entry<Long, List<SoldProductDataDto>> entry : soldProductDataDtoMap.entrySet()) {
            SoldProductCountDto soldProductCountDto = new SoldProductCountDto();
            soldProductCountDto.setCount(entry.getValue().size());
            soldProductCountDto.setProducts(entry.getValue());
            sellerProductsDtoMap.get(entry.getKey()).setSoldProductCountDto(soldProductCountDto);
        }

        usersCountDto.setUsersCount(sellerProductsDtoMap.size());
        usersCountDto.setUsers(new ArrayList<>(sellerProductsDtoMap.values()));
        usersCountDto.getUsers().sort((a, b) ->
                Integer.compare(b.getSoldProductCountDto().getCount(), a.getSoldProductCountDto().getCount()));

        System.out.println(gson.toJson(usersCountDto));

    }
}
