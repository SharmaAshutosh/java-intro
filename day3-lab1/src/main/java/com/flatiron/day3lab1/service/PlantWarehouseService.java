package com.flatiron.day3lab1.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flatiron.day3lab1.data.PlantWarehouse;

@Service
public class PlantWarehouseService {
    
    private Map<String, PlantWarehouse> warehouses = new HashMap<>();
    private PlantWarehouse currentWarehouse;
    
    @Value("${plantservice.mode:DEFAULT}")
    private String currentMode;
    
    @Value("${plantservice.default.serviceName:Default Service}")
    private String defaultServiceName;
    @Value("${plantservice.drone.serviceName:Drone Service}")
    private String droneServiceName;

    @PostConstruct
    private void init() {
        warehouses.put(defaultServiceName, new PlantWarehouse(defaultServiceName));
        warehouses.put(droneServiceName, new PlantWarehouse(droneServiceName));
        currentWarehouse = warehouses.get(currentMode);
    }
    
    public void setWarehouseByName(String name) {
        if(warehouses.containsKey(name)) {
            this.currentWarehouse = warehouses.get(name);
        } else {
            throw new IllegalArgumentException("Invalid warehouse name: " + name);
        }
    }
    
    public void setCurrentWarehouse(PlantWarehouse warehouse) {
        this.currentWarehouse = warehouse;
    }
    
    public PlantWarehouse getCurrentWarehouse() {
        return currentWarehouse;
    }
    
    public void addWareHouse(PlantWarehouse warehouse) {
        warehouses.put(warehouse.getName(), warehouse);
    }
    
    public PlantWarehouse getWareHouse(String name) {
        return warehouses.get(name);
    }

    public void setCurrentMode(String currentMode) {
        this.currentMode = currentMode;
    }

    public void setDefaultServiceName(String defaultServiceName) {
        this.defaultServiceName = defaultServiceName;
    }

    public void setDroneServiceName(String droneServiceName) {
        this.droneServiceName = droneServiceName;
    }
    
    

}
