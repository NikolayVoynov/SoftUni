package com.example.jsonex2;

import com.example.jsonex2.model.dto.CarsMakeFromToyotaDtos;
import com.example.jsonex2.model.dto.CustomersOrderedDtos;
import com.example.jsonex2.model.dto.SupplierLocalDtos;
import com.example.jsonex2.service.*;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    public static final String OUTPUT_FILE_PATH = "src/main/resources/files/out/";
    public static final String CUSTOMERS_ORDERED = "customers-ordered.json";
    public static final String TOYOTA_CARS = "toyota-cars.json";
    public static final String SUPPLIER_LOCAL = "supplier-local.json";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final BufferedReader bufferedReader;
    private final Gson gson;

    public CommandLineRunnerImpl(SupplierService supplierService, PartService partService, CarService carService,
                                 CustomerService customerService, SaleService saleService, Gson gson) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.gson = gson;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Enter exercise number or 0 to exit program:");
        int exerciseNumber = Integer.parseInt(bufferedReader.readLine());

        while (exerciseNumber != 0) {

            switch (exerciseNumber) {
                case 1 -> orderedCustomers();
                case 2 -> carsMakeFromToyota();
                case 3 -> localSuppliers();
//                case 4
//                case 5
//                case 6

            }

            System.out.println("Enter exercise number or 0 to exit program:");
            exerciseNumber = Integer.parseInt(bufferedReader.readLine());
        }

    }

    private void localSuppliers() throws IOException {
        List<SupplierLocalDtos> supplierLocalDtosList =
                supplierService.findSuppliersNotImport();

        String content = gson.toJson(supplierLocalDtosList);

        writeToFile(OUTPUT_FILE_PATH + SUPPLIER_LOCAL, content);
    }

    private void carsMakeFromToyota() throws IOException {
        List<CarsMakeFromToyotaDtos> carsMakeFromToyotaDtosList =
                carService.findCarsMakeByToyota();

        String content = gson.toJson(carsMakeFromToyotaDtosList);

        writeToFile(OUTPUT_FILE_PATH + TOYOTA_CARS, content);
    }

    private void orderedCustomers() throws IOException {
        List<CustomersOrderedDtos> customersOrderedDtosList =
                customerService.findAllCustomersAndOrder();

        String content = gson.toJson(customersOrderedDtosList);

        writeToFile(OUTPUT_FILE_PATH + CUSTOMERS_ORDERED, content);
    }

    private void writeToFile(String filePath, String content) throws IOException {
        Files
                .write(Path.of(filePath), Collections.singleton(content));
    }

    private void seedData() throws IOException {
        supplierService.seedSuppliers();
        partService.seedParts();
        carService.seedCars();
        customerService.seedCustomers();
        saleService.seedSales();
    }
}
