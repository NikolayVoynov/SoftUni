package com.example.jsonex2.service;

import com.example.jsonex2.model.dto.CarsMakeFromToyotaDtos;
import com.example.jsonex2.model.entity.Car;

import java.io.IOException;
import java.util.List;

public interface CarService {
    void seedCars() throws IOException;

    Car findRandomCar();

    List<CarsMakeFromToyotaDtos> findCarsMakeByToyota();

}
