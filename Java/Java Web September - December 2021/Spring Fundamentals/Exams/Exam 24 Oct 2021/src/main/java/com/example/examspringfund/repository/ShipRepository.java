package com.example.examspringfund.repository;

import com.example.examspringfund.model.entity.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity, Long> {
}
