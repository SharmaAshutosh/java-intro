package com.flatiron.day3lab1.data;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Plant {
    @Id
    @GeneratedValue
    Long id;
    
    private String name;
    private BigDecimal price;
    private PlantType type;
    private BigDecimal discount = BigDecimal.ZERO; //default
    
    @ManyToOne
    private PlantWarehouse plantWarehouse;
    
    public Plant() {
    }
    
    public Plant(String name, BigDecimal price, PlantType type) {
        this.name = name;
        this.price = price;
        this.setType(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PlantType getType() {
        return type;
    }

    public void setType(PlantType type) {
        this.type = type;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlantWarehouse getPlantWarehouse() {
        return plantWarehouse;
    }

    public void setPlantWarehouse(PlantWarehouse plantWarehouse) {
        this.plantWarehouse = plantWarehouse;
    }

    
}
