package com.flatiron.day2lab3.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlantServiceConfiguration {
    
    @Bean("defaultPlantService")
    @ConfigurationProperties(prefix="plantservice.default")
    public PlantService getDefaultPlantService() {
        return new PlantService();
    }
    
    @Bean("dronePlantService")
    @ConfigurationProperties(prefix="plantservice.drone")
    public PlantService getDronePlantService() {
        return new PlantService();
    }

}
