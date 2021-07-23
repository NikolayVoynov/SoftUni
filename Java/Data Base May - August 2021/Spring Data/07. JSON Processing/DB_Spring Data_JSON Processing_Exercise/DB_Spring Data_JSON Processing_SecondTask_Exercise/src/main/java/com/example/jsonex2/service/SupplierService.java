package com.example.jsonex2.service;

import com.example.jsonex2.model.dto.SupplierLocalDtos;
import com.example.jsonex2.model.entity.Supplier;

import java.io.IOException;
import java.util.List;

public interface SupplierService {
    void seedSuppliers() throws IOException;

    Supplier findRandomSupplier();

    List<SupplierLocalDtos> findSuppliersNotImport();
}
