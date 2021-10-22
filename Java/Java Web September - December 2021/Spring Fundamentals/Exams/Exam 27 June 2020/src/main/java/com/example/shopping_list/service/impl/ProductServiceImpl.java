package com.example.shopping_list.service.impl;

import com.example.shopping_list.model.entity.CategoryNameEnum;
import com.example.shopping_list.model.entity.ProductEntity;
import com.example.shopping_list.model.service.ProductServiceModel;
import com.example.shopping_list.model.view.ProductViewModel;
import com.example.shopping_list.repository.ProductRepository;
import com.example.shopping_list.sec.CurrentUser;
import com.example.shopping_list.service.CategoryService;
import com.example.shopping_list.service.ProductService;
import com.example.shopping_list.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CurrentUser currentUser;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService, CurrentUser currentUser) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
    }


    @Override
    public void addProduct(ProductServiceModel productServiceModel) {

        ProductEntity productEntity = modelMapper.map(productServiceModel, ProductEntity.class);
        productEntity.setUser(userService.findById(currentUser.getId()));
        productEntity.setCategory(categoryService.findByCategoryNameEnum(productServiceModel.getCategory()));

        productRepository.save(productEntity);

    }

    @Override
    public List<ProductViewModel> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> findAllProductsWithCategory(CategoryNameEnum categoryNameEnum) {
        return productRepository.findAllByCategoryName(categoryNameEnum)
                .stream()
                .map(productEntity -> modelMapper.map(productEntity,ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
