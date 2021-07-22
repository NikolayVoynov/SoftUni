package com.example.jsonex2.model.dto;

import com.google.gson.annotations.Expose;

public class SupplierSeedDtos {

    @Expose
    private String name;
    @Expose
    private boolean isImporter;

    public SupplierSeedDtos() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
