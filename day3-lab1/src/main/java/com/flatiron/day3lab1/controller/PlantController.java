package com.flatiron.day3lab1.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flatiron.day3lab1.data.Plant;
import com.flatiron.day3lab1.data.PlantList;
import com.flatiron.day3lab1.service.PlantService;
import com.flatiron.day3lab1.service.PlantWarehouseService;

@Qualifier("myPlantController")
@RestController
@RequestMapping("/plant")
public class PlantController {
    
    private PlantService plantService;
    private PlantWarehouseService plantWarehouseService;
    
    public PlantController(PlantService plantService, PlantWarehouseService plantWarehouseService) {
        this.plantService = plantService;
        this.plantWarehouseService = plantWarehouseService;
    }
    
    @GetMapping("/{name}")
    public Plant getPlant(String name) {
        return plantService.findPlant(name);
    }
    
    @GetMapping
    public PlantList getAllPlants() {
        return new PlantList(plantService.getAllPlants(), getCurrentServiceName());
    }
    
    @PostMapping
    public void savePlant(@RequestBody Plant plant) {
        plantService.savePlant(plant);
    }
    
    @PutMapping("/{name}/discount/{discount}")
    public void setDiscount(@PathVariable String name, @PathVariable BigDecimal discount) {
        plantService.setDiscount(name, discount);
    }
    
    @GetMapping("/discount")
    public List<Plant> getDiscountedPlants() {
        return plantService.getDiscountedPlants();
    }
    
    @PostMapping("/mode/{mode}")
    public String switchMode(@PathVariable String mode) {
        plantWarehouseService.setWarehouseByName(mode);
        return "Changed mode to " + mode;
    }
    
    public String getCurrentServiceName() {
        return plantService.getServiceName();
    }    
    
}
