package com.example.jsonex2.model.dto;

import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;

public class CustomerSeedDtos {

    @Expose
    private String name;
    @Expose
    private String birthDate;
    @Expose
    private boolean isYoungDriver;

    public CustomerSeedDtos() {

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
}
