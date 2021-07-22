package com.example.jsonex.model.dto;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class UsersCountDto {

    @Expose
    private int usersCount;
    @Expose
    private List<SellerProductsDto> users = new ArrayList<>();

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public List<SellerProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<SellerProductsDto> users) {
        this.users = users;
    }
}
