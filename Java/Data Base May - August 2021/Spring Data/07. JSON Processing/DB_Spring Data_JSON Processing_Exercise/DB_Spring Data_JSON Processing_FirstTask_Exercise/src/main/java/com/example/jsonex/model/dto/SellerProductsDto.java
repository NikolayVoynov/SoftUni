package com.example.jsonex.model.dto;

import com.google.gson.annotations.Expose;

public class SellerProductsDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private SoldProductCountDto soldProductCountDto;


    public SellerProductsDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SoldProductCountDto getSoldProductCountDto() {
        return soldProductCountDto;
    }

    public void setSoldProductCountDto(SoldProductCountDto soldProductCountDto) {
        this.soldProductCountDto = soldProductCountDto;
    }
}
