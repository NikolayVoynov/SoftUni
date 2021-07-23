package com.example.jsonex2.repository;

import com.example.jsonex2.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Override
    List<Sale> findAll();
}
