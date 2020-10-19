package com.flatiron.day3lab2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flatiron.day3lab2.service.PlantWarehouseService;

@ControllerAdvice
public class PlantDeliveryExceptionHandler {
    
    private PlantWarehouseService plantWarehouseService;
    
    @Value("${inspirational.quote:Good luck!}")
    private String quote;
    
    
    public PlantDeliveryExceptionHandler(PlantWarehouseService plantWarehouseService) {
        this.plantWarehouseService = plantWarehouseService;
    }
    
    @ExceptionHandler
    public ResponseEntity<PlantExceptionResponse> handleAllExceptions(Exception e) {
        PlantExceptionResponse response = new PlantExceptionResponse(plantWarehouseService.getCurrentWarehouseName(), e.getMessage(), quote);
        return new ResponseEntity<PlantExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }


    private class PlantExceptionResponse {
        private String currentServiceName;
        private String message;
        private String inspirationalQuote;
        public PlantExceptionResponse(String serviceName, String message, String quote) {
            this.currentServiceName = serviceName;
            this.message = message;
            this.inspirationalQuote = quote;
        }
        public String getCurrentServiceName() {
            return currentServiceName;
        }
        public String getMessage() {
            return message;
        }
        public String getInspirationalQuote() {
            return inspirationalQuote;
        }
    }

}
