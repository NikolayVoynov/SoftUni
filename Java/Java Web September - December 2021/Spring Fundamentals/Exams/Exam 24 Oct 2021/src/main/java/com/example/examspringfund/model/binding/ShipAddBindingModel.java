package com.example.examspringfund.model.binding;

import com.example.examspringfund.model.entity.CategoryEntity;
import com.example.examspringfund.model.entity.CategoryNameEnum;
import com.example.examspringfund.model.entity.UserEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ShipAddBindingModel {

    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryNameEnum category;


    public ShipAddBindingModel() {
    }

    @Size(min = 2, max = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Positive
    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    @Positive
    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @NotNull
    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }
}
