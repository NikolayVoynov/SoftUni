package com.example.jsonex.model.dto;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class SoldProductCountDto {

    @Expose
    private int count;
    @Expose
    private List<SoldProductDataDto> products = new ArrayList<>();

    public SoldProductCountDto() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<SoldProductDataDto> getProducts() {
        return products;
    }

    public void setProducts(List<SoldProductDataDto> products) {
        this.products = products;
    }
}
