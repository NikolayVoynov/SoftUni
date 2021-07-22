package com.example.jsonex2.service;

import com.example.jsonex2.model.entity.Supplier;

import java.io.IOException;

public interface SupplierService {
    void seedSuppliers() throws IOException;

    Supplier findRandomSupplier();
}
