package com.flatiron.day2lab3.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flatiron.day2lab3.data.Plant;
import com.flatiron.day2lab3.data.PlantList;
import com.flatiron.day2lab3.service.PlantService;

@Qualifier("myPlantController")
@RestController
@RequestMapping("/plant")
public class PlantController {
    
    private PlantService defaultPlantService;
    private PlantService dronePlantService;
    
    private PlantService plantService;
    
    @Value("${plantservice.mode:DEFAULT}")
    private String startingMode;
    
    private final String defaultServiceName;
    private final String droneServiceName;
    

    public PlantController(@Qualifier("defaultPlantService") PlantService defaultPlantService,
            @Qualifier("dronePlantService") PlantService dronePlantService) {
        this.defaultPlantService = defaultPlantService;
        this.dronePlantService = dronePlantService;
        defaultServiceName = defaultPlantService.getServiceName();
        droneServiceName = dronePlantService.getServiceName();
    }
    
    @PostConstruct
    private void init() {
        switchMode(startingMode);
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
        if(mode.equalsIgnoreCase(defaultServiceName)) {
            plantService = defaultPlantService;
        } else if (mode.equalsIgnoreCase(droneServiceName)) {
            return "Drone Plant Service Activated";
        } else {
            throw new IllegalArgumentException("Invalid service: " + mode);
        }
        return "Service Activated: " + mode;
    }
    
    public String getCurrentServiceName() {
        return plantService.getServiceName();
    }

    public String getStartingMode() {
        return startingMode;
    }

    public void setStartingMode(String startingMode) {
        this.startingMode = startingMode;
    }
    
    
}
