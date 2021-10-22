package com.example.shopping_list.repository;

import com.example.shopping_list.model.entity.CategoryNameEnum;
import com.example.shopping_list.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByCategoryName(CategoryNameEnum categoryNameEnum);

}
