package com.example.jsonex2.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{

    private String name;
    private LocalDateTime birthDate;
    private boolean isYoungDriver;
    private List<Sale> Sales;

    public Customer() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "is_young_driver")
    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    public List<Sale> getSales() {
        return Sales;
    }

    public void setSales(List<Sale> sales) {
        Sales = sales;
    }
}
