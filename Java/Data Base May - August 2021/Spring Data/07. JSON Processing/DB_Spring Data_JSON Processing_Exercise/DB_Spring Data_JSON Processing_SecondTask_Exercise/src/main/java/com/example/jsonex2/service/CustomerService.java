package com.example.jsonex2.service;

import com.example.jsonex2.model.dto.CustomersOrderedDtos;
import com.example.jsonex2.model.entity.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    void seedCustomers() throws IOException;

    Customer findRandomCustomer();

    List<CustomersOrderedDtos> findAllCustomersAndOrder();
}
