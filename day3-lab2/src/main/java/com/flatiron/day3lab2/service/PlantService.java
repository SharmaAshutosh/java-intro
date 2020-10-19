package com.flatiron.day3lab2.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.flatiron.day3lab2.data.plant.Plant;
import com.flatiron.day3lab2.data.plant.PlantRepository;
import com.flatiron.day3lab2.data.plantwarehouse.PlantWarehouse;

@Service
public class PlantService {
    
    private PlantWarehouseService plantWarehouseService;
    PlantRepository plantRepository;
    
    public PlantService(PlantWarehouseService plantWarehouseService, PlantRepository plantRepository) {
        this.plantWarehouseService = plantWarehouseService;
        this.plantRepository = plantRepository;
    }
    
    public Plant findPlant(String name) {
        return plantRepository.findByName(name);
    }
    
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }
    
    public void savePlant(@RequestBody Plant plant) {
        PlantWarehouse currentWarehouse = plantWarehouseService.getCurrentWarehouse();
        if(currentWarehouse.getPlants() == null) {
            currentWarehouse.setPlants(new ArrayList<>());
        }
        currentWarehouse.getPlants().add(plant);
        plant.setPlantWarehouse(currentWarehouse);
        plantRepository.save(plant);
    }

    public void setDiscount(String name, BigDecimal discount) {
        Plant p = plantRepository.findByName(name);
        if(p != null) {
            p.setDiscount(discount);
        }         
    }

    public List<Plant> getDiscountedPlants() {
        return plantRepository.findAll().stream()
                .filter(plant -> plant.getDiscount().compareTo(BigDecimal.ZERO) != 0)
                .collect(Collectors.toList());
    }
    
    public PlantWarehouseService getPlantWarehouseService() {
        return plantWarehouseService;
    }

    public void setPlantWarehouseService(PlantWarehouseService plantWarehouseService) {
        this.plantWarehouseService = plantWarehouseService;
    }

    public PlantRepository getPlantRepository() {
        return plantRepository;
    }

    public void setPlantRepository(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }
    
    
}
