package com.example.shopping_list.service;

import com.example.shopping_list.model.entity.CategoryNameEnum;
import com.example.shopping_list.model.service.ProductServiceModel;
import com.example.shopping_list.model.view.ProductViewModel;

import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel);

    List<ProductViewModel> findAllProducts();

    List<ProductViewModel> findAllProductsWithCategory(CategoryNameEnum categoryNameEnum);

    void buyProduct(Long id);

    void buyAll();

}
