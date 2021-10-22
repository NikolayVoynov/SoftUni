package com.example.shopping_list.repository;

import com.example.shopping_list.model.entity.CategoryEntity;
import com.example.shopping_list.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByName(CategoryNameEnum categoryNameEnum);
}
