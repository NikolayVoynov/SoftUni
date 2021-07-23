package com.example.jsonex2.service.impl;

import com.example.jsonex2.constants.GlobalConstants;
import com.example.jsonex2.model.dto.SupplierLocalDtos;
import com.example.jsonex2.model.dto.SupplierSeedDtos;
import com.example.jsonex2.model.entity.Supplier;
import com.example.jsonex2.repository.SupplierRepository;
import com.example.jsonex2.service.SupplierService;
import com.example.jsonex2.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static final String SUPPLIERS_FILE_NAME = "suppliers.json";

    private final SupplierRepository supplierRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public SupplierServiceImpl(SupplierRepository supplierRepository, Gson gson,
                               ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedSuppliers() throws IOException {

        if (supplierRepository.count() > 0) {
            return;
        }

        String fileContent = Files
                .readString(Path.of(GlobalConstants.RESOURCES_FILE_PATH + SUPPLIERS_FILE_NAME));

        SupplierSeedDtos[] supplierSeedDtos = gson
                .fromJson(fileContent, SupplierSeedDtos[].class);

        Arrays.stream(supplierSeedDtos)
                .filter(validationUtil::isValid)
                .map(supplierSeedDto -> modelMapper.map(supplierSeedDto, Supplier.class))
                .forEach(supplierRepository::save);

    }

    @Override
    public Supplier findRandomSupplier() {
        Supplier supplier = new Supplier();
        long totalSuppliersCount = supplierRepository.count();
        long randomId = ThreadLocalRandom.current().nextLong(1, totalSuppliersCount + 1);
        supplier = supplierRepository.findById(randomId).orElse(null);

        return supplier;
    }

    @Override
    public List<SupplierLocalDtos> findSuppliersNotImport() {

        List<Object[]> objectListSuppliers = supplierRepository.findSupplierNotImporterAndCountParts();

        List<SupplierLocalDtos> supplierLocalDtosList = new ArrayList<>();

        for (Object[] objectListSupplier : objectListSuppliers) {
            boolean checkIsImporter = (boolean) objectListSupplier[3];
            if (!checkIsImporter) {
                long id = (long) objectListSupplier[0];
                String name = (String) objectListSupplier[1];
                long partsCount = (long) objectListSupplier[2];

                SupplierLocalDtos supplierLocalDtos = new SupplierLocalDtos(id,name, partsCount);

                supplierLocalDtosList.add(supplierLocalDtos);
            }
        }

        return supplierLocalDtosList;
    }
}
