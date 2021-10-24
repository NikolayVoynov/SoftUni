package com.example.examspringfund.repository;

import com.example.examspringfund.model.entity.CategoryEntity;
import com.example.examspringfund.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByName(CategoryNameEnum name);
}
