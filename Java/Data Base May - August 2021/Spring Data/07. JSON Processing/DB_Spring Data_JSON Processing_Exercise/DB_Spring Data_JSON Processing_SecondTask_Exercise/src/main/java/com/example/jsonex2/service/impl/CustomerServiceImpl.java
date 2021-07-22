package com.example.jsonex2.service.impl;

import com.example.jsonex2.constants.GlobalConstants;
import com.example.jsonex2.model.dto.CustomerSeedDtos;
import com.example.jsonex2.model.entity.Customer;
import com.example.jsonex2.model.entity.Supplier;
import com.example.jsonex2.repository.CustomerRepository;
import com.example.jsonex2.service.CustomerService;
import com.example.jsonex2.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String CUSTOMERS_FILE_PATH = "customers.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil,
                               CustomerRepository customerRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.customerRepository = customerRepository;
    }

    @Override
    public void seedCustomers() throws IOException {

        if (customerRepository.count() > 0) {
            return;
        }

        String fileContent = Files
                .readString(Path.of(GlobalConstants.RESOURCES_FILE_PATH + CUSTOMERS_FILE_PATH));

        CustomerSeedDtos[] customerSeedDtos = gson
                .fromJson(fileContent, CustomerSeedDtos[].class);

        Arrays.stream(customerSeedDtos)
                .filter(validationUtil::isValid)
                .map(customerSeedDto -> modelMapper.map(customerSeedDto, Customer.class))
                .forEach(customerRepository::save);

    }

    @Override
    public Customer findRandomCustomer() {
        Customer customer = new Customer();
        long totalCustomersCount = customerRepository.count();
        long randomId = ThreadLocalRandom.current().nextLong(1, totalCustomersCount + 1);
        customer = customerRepository.findById(randomId).orElse(null);

        return customer;
    }
}
