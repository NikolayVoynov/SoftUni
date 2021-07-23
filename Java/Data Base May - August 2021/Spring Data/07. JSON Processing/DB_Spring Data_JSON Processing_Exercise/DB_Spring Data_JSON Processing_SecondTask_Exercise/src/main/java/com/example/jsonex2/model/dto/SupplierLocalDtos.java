package com.example.jsonex2.model.dto;

import com.google.gson.annotations.Expose;

public class SupplierLocalDtos {
    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private Long partsCount;

    public SupplierLocalDtos() {
    }

    public SupplierLocalDtos(Long id, String name, Long partsCount) {
        this.id = id;
        this.name = name;
        this.partsCount = partsCount;
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

    public Long getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(Long partsCount) {
        this.partsCount = partsCount;
    }
}
