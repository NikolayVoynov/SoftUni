package com.example.shopping_list.model.view;

import com.example.shopping_list.model.entity.CategoryEntity;
import com.example.shopping_list.model.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductViewModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private CategoryEntity category;
    private UserEntity user;

    public ProductViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
