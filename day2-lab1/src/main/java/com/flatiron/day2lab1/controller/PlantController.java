package com.flatiron.day2lab1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flatiron.day2lab1.data.Plant;

@RestController
@RequestMapping("/plant")
public class PlantController {
    
    Map<String, Plant> plantMap = new HashMap<>();
    
    @GetMapping("/{name}")
    public Plant getPlant(String name) {
        return plantMap.getOrDefault(name, new Plant());
    }
    
    @GetMapping
    public List<Plant> getAllPlants() {
        return new ArrayList<Plant>(plantMap.values());
    }
    
    @PostMapping
    public void savePlant(@RequestBody Plant plant) {
        plantMap.put(plant.getName(), plant);
    }
}
