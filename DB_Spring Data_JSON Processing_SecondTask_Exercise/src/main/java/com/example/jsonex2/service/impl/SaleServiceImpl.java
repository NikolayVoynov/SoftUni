package com.example.jsonex2.service.impl;

import com.example.jsonex2.model.dto.SaleSeedDtos;
import com.example.jsonex2.repository.SaleRepository;
import com.example.jsonex2.service.CarService;
import com.example.jsonex2.service.CustomerService;
import com.example.jsonex2.service.SaleService;
import com.example.jsonex2.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class SaleServiceImpl implements SaleService {


    private static final String CARS_FILE_NAME = "cars.json";

    private final static double[] discountsArray = new double[]{0.0, 0.05, 0.1, 0.15, 0.2, 0.3, 0.4, 0.5};

    private final CarService carService;
    private final CustomerService customerService;
    private final SaleRepository saleRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final SaleSeedDtos saleSeedDtos;

    public SaleServiceImpl( CarService carService, CustomerService customerService,
                           SaleRepository saleRepository, ValidationUtil validationUtil,
                           ModelMapper modelMapper) {
        this.saleSeedDtos = new SaleSeedDtos();
        this.carService = carService;
        this.customerService = customerService;
        this.saleRepository = saleRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSales() {
        saleSeedDtos.setCar(carService.findRandomCar());
        saleSeedDtos.setCustomer(customerService.findRandomCustomer());
        saleSeedDtos.setDiscount(findRandomDiscount());

    }


    @Override
    public Double findRandomDiscount() {
        Double discount = null;
        int discountArrayLength = discountsArray.length;
        int randomIndex = ThreadLocalRandom.current().nextInt(0, discountArrayLength);
        discount = discountsArray[randomIndex];

        return discount;
    }


}
