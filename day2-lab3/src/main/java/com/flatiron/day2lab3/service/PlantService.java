package com.flatiron.day2lab3.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.flatiron.day2lab3.data.Plant;

@Service
public class PlantService {

    private String serviceName = "DEFAULT";
    private Map<String, Plant> plantMap = new HashMap<>();
    
    public Plant findPlant(String name) {
        return plantMap.getOrDefault(name, new Plant());
    }
    
    public List<Plant> getAllPlants() {
        return new ArrayList<Plant>(plantMap.values());
    }
    
    public void savePlant(@RequestBody Plant plant) {
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
}
