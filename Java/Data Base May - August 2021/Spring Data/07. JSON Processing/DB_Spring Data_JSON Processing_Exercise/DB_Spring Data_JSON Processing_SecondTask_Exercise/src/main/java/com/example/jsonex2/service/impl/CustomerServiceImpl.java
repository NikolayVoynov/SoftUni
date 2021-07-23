package com.example.jsonex2.service.impl;

import com.example.jsonex2.constants.GlobalConstants;
import com.example.jsonex2.model.dto.CustomerOrderedSalesDtos;
import com.example.jsonex2.model.dto.CustomerSeedDtos;
import com.example.jsonex2.model.dto.CustomersOrderedDtos;
import com.example.jsonex2.model.entity.Customer;
import com.example.jsonex2.model.entity.Sale;
import com.example.jsonex2.repository.CustomerRepository;
import com.example.jsonex2.repository.SaleRepository;
import com.example.jsonex2.service.CustomerService;
import com.example.jsonex2.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String CUSTOMERS_FILE_PATH = "customers.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;

    public CustomerServiceImpl(ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil,
                               CustomerRepository customerRepository, SaleRepository saleRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
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
                .map(customerSeedDto -> {
                    Customer customer = modelMapper.map(customerSeedDto, Customer.class);

                    customer.setBirthDate(LocalDateTime.parse(
                            customerSeedDto.getBirthDate(),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));

                    return customer;
                })
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

    @Override
    public List<CustomersOrderedDtos> findAllCustomersAndOrder() {



        return customerRepository
                .getCustomersOrderedByBirthDateIsYoungDriver()
                .stream()
                .map(customer -> {
                    CustomersOrderedDtos customersOrderedDto =
                            modelMapper.map(customer, CustomersOrderedDtos.class);

                    customersOrderedDto.setId(customer.getId());
                    customersOrderedDto.setName(customer.getName());
                    customersOrderedDto.setBirthDate(customer.getBirthDate().toString());
                    customersOrderedDto.setYoungDriver(customer.isYoungDriver());

                    CustomerOrderedSalesDtos customerOrderedSalesDtos = new CustomerOrderedSalesDtos();
                    List<CustomerOrderedSalesDtos> customerOrderedSalesDtosList = new ArrayList<>();
                    List<Sale> customerSales = customer.getSales();

                    for (Sale customerSale : customerSales) {
                        customerOrderedSalesDtos.setId(customerSale.getId());
                        customerOrderedSalesDtos.setDiscount(customerSale.getDiscount());
                        customerOrderedSalesDtos.setCar_id(customerSale.getCar().getId());
                        customerOrderedSalesDtos.setCustomer_id(customerSale.getCustomer().getId());

                        customerOrderedSalesDtosList.add(customerOrderedSalesDtos);
                        customerOrderedSalesDtos = new CustomerOrderedSalesDtos();
                    }

                    customersOrderedDto.setSales(customerOrderedSalesDtosList);

                    return customersOrderedDto;
                })
                .collect(Collectors.toList());
    }
}
