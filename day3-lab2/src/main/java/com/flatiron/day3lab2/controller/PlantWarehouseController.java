package com.flatiron.day3lab2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.flatiron.day3lab2.data.plantwarehouse.PlantWarehouse;
import com.flatiron.day3lab2.service.PlantWarehouseService;

@RestController
@RequestMapping("/warehouse")
public class PlantWarehouseController {
    
    PlantWarehouseService plantWarehouseService;
    
    public PlantWarehouseController(PlantWarehouseService plantWarehouseService) {
        this.plantWarehouseService = plantWarehouseService;
    }
    
    @GetMapping
    @JsonView(PlantAppViews.Public.class)
    public List<PlantWarehouse> getAllWarehouse() {
        return plantWarehouseService.findAll();
    }
    
    @GetMapping("/{name}")
    @JsonView(PlantAppViews.Public.class)
    public PlantWarehouse getWarehouse(@PathVariable String name) {
        return plantWarehouseService.getWareHouse(name);
    }
    
    @PostMapping("/activate/{mode}")
    @JsonView(PlantAppViews.Public.class)
    public String switchMode(@PathVariable String mode) {
        plantWarehouseService.setWarehouseByName(mode);
        return "Changed mode to " + mode;
    }
}
