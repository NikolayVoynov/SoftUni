package com.example.jsonex2.service;

import com.example.jsonex2.model.dto.SaleSeedDtos;

import java.io.IOException;

public interface SaleService {

    void seedSales() throws IOException;

    Double findRandomDiscount();
}
