package com.flatiron.day3lab2.data.plant;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.flatiron.day3lab2.controller.PlantAppViews;
import com.flatiron.day3lab2.data.plantwarehouse.PlantWarehouse;

@Entity
public class Plant {
    @Id
    @GeneratedValue
    Long id;
    
    @JsonView(PlantAppViews.Public.class)
    private String name;
    @JsonView(PlantAppViews.Public.class)
    private BigDecimal price;
    @JsonView(PlantAppViews.Public.class)
    private PlantType type;
    @JsonView(PlantAppViews.Public.class)
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
