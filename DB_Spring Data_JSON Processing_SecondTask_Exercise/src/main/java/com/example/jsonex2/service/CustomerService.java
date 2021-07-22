package com.example.jsonex2.service;

import com.example.jsonex2.model.entity.Customer;

import java.io.IOException;

public interface CustomerService {

    void seedCustomers() throws IOException;

    Customer findRandomCustomer();
}
