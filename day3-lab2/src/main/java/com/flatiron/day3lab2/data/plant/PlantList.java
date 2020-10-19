package com.flatiron.day3lab2.data.plant;

import java.util.List;

public class PlantList {
    private String currentService;
    private List<Plant> plants;

    public PlantList(List<Plant> plants, String currentService) {
        this.currentService = currentService;
        this.plants = plants;
    }
    
    public String getCurrentService() {
        return currentService;
    }
    public void setCurrentService(String currentService) {
        this.currentService = currentService;
    }
    public List<Plant> getPlants() {
        return plants;
    }
    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
