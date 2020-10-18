package com.flatiron.day2lab2.data;

import java.math.BigDecimal;

public class Plant {
    private String name;
    private BigDecimal price;
    private PlantType type;
    private BigDecimal discount = BigDecimal.ZERO; //default
    
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

}
