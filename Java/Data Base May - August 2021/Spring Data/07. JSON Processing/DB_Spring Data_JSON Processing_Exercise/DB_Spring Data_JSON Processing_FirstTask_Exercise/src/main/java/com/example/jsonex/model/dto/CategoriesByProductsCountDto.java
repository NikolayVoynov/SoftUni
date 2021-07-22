package com.example.jsonex.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.Set;

public class CategoriesByProductsCountDto {
    @Expose
    private String name;
    @Expose
    private Integer productsCount;
    @Expose
    private BigDecimal averagePrice;
    @Expose
    private BigDecimal totalRevenue;

    public CategoriesByProductsCountDto() {
    }

    public CategoriesByProductsCountDto(String name, Integer productsCount,
                                        BigDecimal averagePrice, BigDecimal totalRevenue) {
        this.name = name;
        this.productsCount = productsCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(Integer productsCount) {
        this.productsCount = productsCount;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
