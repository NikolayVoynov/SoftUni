package com.example.jsonex2.service.impl;

import com.example.jsonex2.constants.GlobalConstants;
import com.example.jsonex2.model.dto.CarSeedDtos;
import com.example.jsonex2.model.entity.Car;
import com.example.jsonex2.repository.CarRepository;
import com.example.jsonex2.service.CarService;
import com.example.jsonex2.service.PartService;
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
public class CarServiceImpl implements CarService {

    private static final String CARS_FILE_NAME = "cars.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final CarRepository carRepository;
    private final PartService partService;

    public CarServiceImpl(ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, CarRepository carRepository, PartService partService) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.carRepository = carRepository;
        this.partService = partService;
    }


    @Override
    public void seedCars() throws IOException {

        if (carRepository.count() > 0) {
            return;
        }

        String fileContent = Files
                .readString(Path.of(GlobalConstants.RESOURCES_FILE_PATH + CARS_FILE_NAME));

        CarSeedDtos[] carSeedDtos = gson
                .fromJson(fileContent, CarSeedDtos[].class);

        Arrays.stream(carSeedDtos)
                .filter(validationUtil::isValid)
                .map(carSeedDto -> {
                    Car car = modelMapper.map(carSeedDto, Car.class);
                    car.setParts(partService.findRandomParts());

                    return car;
                })
                .forEach(carRepository::save);

    }

    @Override
    public Car findRandomCar() {
        Car car = new Car();
        long totalCarsCount = carRepository.count();
        long randomId = ThreadLocalRandom.current().nextLong(1, totalCarsCount + 1);
        car = carRepository.findById(randomId).orElse(null);

        return car;
    }
}
