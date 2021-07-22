package com.example.jsonex2.model.dto;

import com.example.jsonex2.model.entity.Car;
import com.example.jsonex2.model.entity.Customer;
import com.google.gson.annotations.Expose;

public class SaleSeedDtos {

    @Expose
    private Double discount;
    @Expose
    private Car car;
    @Expose
    private Customer customer;

    public SaleSeedDtos() {
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

