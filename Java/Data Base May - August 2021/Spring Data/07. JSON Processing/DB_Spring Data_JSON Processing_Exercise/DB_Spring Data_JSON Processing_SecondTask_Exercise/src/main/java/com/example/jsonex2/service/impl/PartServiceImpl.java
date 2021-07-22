package com.example.jsonex2.service.impl;

import com.example.jsonex2.constants.GlobalConstants;
import com.example.jsonex2.model.dto.PartSeedDtos;
import com.example.jsonex2.model.entity.Part;
import com.example.jsonex2.repository.PartRepository;
import com.example.jsonex2.service.PartService;
import com.example.jsonex2.service.SupplierService;
import com.example.jsonex2.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {

    private static final String PARTS_FILE_NAME = "parts.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final PartRepository partRepository;
    private final SupplierService supplierService;

    public PartServiceImpl(ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil,
                           PartRepository partRepository, SupplierService supplierService) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.partRepository = partRepository;
        this.supplierService = supplierService;
    }

    @Override
    public void seedParts() throws IOException {

        if (partRepository.count() > 0) {
            return;
        }

        String fileContent = Files
                .readString(Path.of(GlobalConstants.RESOURCES_FILE_PATH + PARTS_FILE_NAME));

        PartSeedDtos[] partSeedDtos = gson
                .fromJson(fileContent, PartSeedDtos[].class);

        Arrays.stream(partSeedDtos)
                .filter(validationUtil::isValid)
                .map(partSeedDto -> {
                    Part part = modelMapper.map(partSeedDto, Part.class);

                    part.setSupplier(supplierService.findRandomSupplier());

                    return part;
                })
                .forEach(partRepository::save);
    }

    @Override
    public Set<Part> findRandomParts() {
        Set<Part> partSet = new HashSet<>();
        long totalPartsCount = partRepository.count();
        int partCount = ThreadLocalRandom.current().nextInt(3, 6);

        for (int i = 0; i < partCount; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, totalPartsCount + 1);

            partSet.add(partRepository.getById(randomId));
        }

        return partSet;
    }
}
