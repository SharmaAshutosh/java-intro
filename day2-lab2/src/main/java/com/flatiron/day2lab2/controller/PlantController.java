package com.flatiron.day2lab2.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flatiron.day2lab2.data.Plant;
import com.flatiron.day2lab2.service.PlantService;

@RestController
@RequestMapping("/plant")
public class PlantController {
    
    private PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }
    
    @GetMapping("/{name}")
    public Plant getPlant(String name) {
        return plantService.findPlant(name);
    }
    
    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
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
}
