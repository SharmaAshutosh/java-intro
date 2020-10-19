package com.flatiron.day3lab2.data.plantwarehouse;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.flatiron.day3lab2.controller.PlantAppViews;
import com.flatiron.day3lab2.data.plant.Plant;

@Entity
public class PlantWarehouse {
    @Id
    @GeneratedValue
    private Long id;
    
    @JsonView(PlantAppViews.Public.class)
    private String name;
    
    @OneToMany(mappedBy="plantWarehouse")
    @JsonView(PlantAppViews.Public.class)
    private List<Plant> plants;
    
    public PlantWarehouse() {
        
    }
    
    public PlantWarehouse(String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Plant> getPlants() {
        return plants;
    }
    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
