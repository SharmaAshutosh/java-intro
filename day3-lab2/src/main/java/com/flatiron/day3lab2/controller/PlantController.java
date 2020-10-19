package com.flatiron.day3lab2.controller;

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

import com.fasterxml.jackson.annotation.JsonView;
import com.flatiron.day3lab2.data.plant.Plant;
import com.flatiron.day3lab2.data.plant.PlantList;
import com.flatiron.day3lab2.service.PlantService;
import com.flatiron.day3lab2.service.PlantWarehouseService;

@Qualifier("myPlantController")
@RestController
@RequestMapping("/plant")
public class PlantController {
    
    private PlantService plantService;
    private PlantWarehouseService plantWarehouseService;
    
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }
    
    @GetMapping("/{name}")
    @JsonView(PlantAppViews.Public.class)
    public Plant getPlant(String name) {
        return plantService.findPlant(name);
    }
    
    @GetMapping
    @JsonView(PlantAppViews.Public.class)
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }
    
    @PostMapping
    @JsonView(PlantAppViews.Public.class)
    public void savePlant(@RequestBody Plant plant) {
        plantService.savePlant(plant);
    }
    
    @PutMapping("/{name}/discount/{discount}")
    @JsonView(PlantAppViews.Public.class)
    public void setDiscount(@PathVariable String name, @PathVariable BigDecimal discount) {
        plantService.setDiscount(name, discount);
    }
    
    @GetMapping("/discount")
    @JsonView(PlantAppViews.Public.class)
    public List<Plant> getDiscountedPlants() {
        return plantService.getDiscountedPlants();
    }
    
}
