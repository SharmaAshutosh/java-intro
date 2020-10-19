package com.flatiron.day3lab1.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.flatiron.day3lab1.data.Plant;
import com.flatiron.day3lab1.data.PlantWarehouse;

@Service
public class PlantService {
    
    private PlantWarehouseService plantWarehouseService;
    
    private String serviceName = "DEFAULT";
    private Map<String, Plant> plantMap = new HashMap<>();
    
    public PlantService(PlantWarehouseService plantWarehouseService) {
        this.plantWarehouseService = plantWarehouseService;
    }
    
    public Plant findPlant(String name) {
        return plantMap.getOrDefault(name, new Plant());
    }
    
    public List<Plant> getAllPlants() {
        return new ArrayList<Plant>(plantMap.values());
    }
    
    public void savePlant(@RequestBody Plant plant) {
        PlantWarehouse currentWarehouse = plantWarehouseService.getCurrentWarehouse();
        if(currentWarehouse.getPlants() == null) {
            currentWarehouse.setPlants(new ArrayList<>());
        }
        currentWarehouse.getPlants().add(plant);
        plant.setPlantWarehouse(currentWarehouse);
        plantMap.put(plant.getName(), plant);
    }

    public void setDiscount(String name, BigDecimal discount) {
        if(plantMap.containsKey(name)) {
            plantMap.get(name).setDiscount(discount);
        }         
    }

    public List<Plant> getDiscountedPlants() {
        return plantMap.values().stream()
                .filter(plant -> plant.getDiscount().compareTo(BigDecimal.ZERO) != 0)
                .collect(Collectors.toList());
    }
    
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public PlantWarehouseService getPlantWarehouseService() {
        return plantWarehouseService;
    }

    public void setPlantWarehouseService(PlantWarehouseService plantWarehouseService) {
        this.plantWarehouseService = plantWarehouseService;
    }
}
