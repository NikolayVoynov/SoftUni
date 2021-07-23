package com.example.jsonex2.model.dto;

import com.example.jsonex2.model.entity.Sale;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


public class CustomersOrderedDtos {

    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private String birthDate;
    @Expose
    private boolean isYoungDriver;
    @Expose
    private List<CustomerOrderedSalesDtos> sales;


    public CustomersOrderedDtos() {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public List<CustomerOrderedSalesDtos> getSales() {
        return sales;
    }

    public void setSales(List<CustomerOrderedSalesDtos> sales) {
        this.sales = sales;
    }
}
