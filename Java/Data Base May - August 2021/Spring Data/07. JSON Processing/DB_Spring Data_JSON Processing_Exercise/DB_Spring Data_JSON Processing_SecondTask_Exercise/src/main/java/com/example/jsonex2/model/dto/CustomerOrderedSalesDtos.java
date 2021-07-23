package com.example.jsonex2.model.dto;

import com.google.gson.annotations.Expose;

public class CustomerOrderedSalesDtos {

    @Expose
    private Long id;
    @Expose
    private Double discount;
    @Expose
    private Long car_id;
    @Expose
    private Long customer_id;

    public CustomerOrderedSalesDtos() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}
