package com.example.jsonex.repository;

import com.example.jsonex.model.dto.CategoriesByProductsCountDto;
import com.example.jsonex.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c.name, COUNT(p.id), AVG(p.price), SUM(p.price) " +
            "FROM Product p " +
            "JOIN p.categories c " +
            "GROUP BY c.name " +
            "ORDER BY count (p.id) DESC")
    List<Object[]> getCategoriesCount();
}
