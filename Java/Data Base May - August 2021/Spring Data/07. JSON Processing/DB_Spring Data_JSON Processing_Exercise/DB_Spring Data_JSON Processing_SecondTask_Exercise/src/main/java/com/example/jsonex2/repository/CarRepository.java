package com.example.jsonex2.repository;

import com.example.jsonex2.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c " +
    "WHERE c.make LIKE 'Toyota' " +
    "ORDER BY c.model, c.travelledDistance DESC")
    List<Car> getCarsMakeByToyota();
}
