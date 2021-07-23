package com.example.jsonex2.repository;

import com.example.jsonex2.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT s.id, s.name, COUNT(p.id), s.importer FROM Part p " +
            "JOIN p.supplier s " +
            "GROUP BY s.id "
    )
    List<Object[]> findSupplierNotImporterAndCountParts();


}
