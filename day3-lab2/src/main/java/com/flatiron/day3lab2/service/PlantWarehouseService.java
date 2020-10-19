package com.flatiron.day3lab2.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flatiron.day3lab2.data.plantwarehouse.PlantWarehouse;
import com.flatiron.day3lab2.data.plantwarehouse.PlantWarehouseRepository;

@Service
public class PlantWarehouseService {
    
    private PlantWarehouseRepository plantWarehouseRepository;
    
    @Value("${plantservice.mode:DEFAULT}")
    private String currentMode;
    
    @Value("${plantservice.default.serviceName:Default Service}")
    private String defaultServiceName;
    @Value("${plantservice.drone.serviceName:Drone Service}")
    private String droneServiceName;

    public PlantWarehouseService(PlantWarehouseRepository plantWarehouseRepository) {
        this.plantWarehouseRepository = plantWarehouseRepository;
    }
    
    @PostConstruct
    private void init() {
        plantWarehouseRepository.save(new PlantWarehouse(defaultServiceName));
        plantWarehouseRepository.save(new PlantWarehouse(droneServiceName));
    }
    
    public void setWarehouseByName(String name) {
        PlantWarehouse warehouse = plantWarehouseRepository.findByName(name);
        if(warehouse != null) {
            this.currentMode = name;
        } else {
            throw new IllegalArgumentException("Invalid warehouse name: " + name);
        }
    }
    
    public List<PlantWarehouse> findAll() {
        return plantWarehouseRepository.findAll();
    }
    
    public PlantWarehouse getCurrentWarehouse() {
        return plantWarehouseRepository.findByName(currentMode);
    }
    
    public void addWareHouse(PlantWarehouse warehouse) {
        plantWarehouseRepository.save(warehouse);
    }
    
    public PlantWarehouse getWareHouse(String name) {
        return plantWarehouseRepository.findByName(name);
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

    public String getCurrentWarehouseName() {
        return currentMode;
    }

}
