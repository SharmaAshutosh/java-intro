package com.flatiron.day3lab1.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PlantWarehouse {
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy="plantWarehouse")
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
