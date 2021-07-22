package com.example.jsonex2.service;

import com.example.jsonex2.model.entity.Car;

import java.io.IOException;

public interface CarService {
    void seedCars() throws IOException;

    Car findRandomCar();
}
