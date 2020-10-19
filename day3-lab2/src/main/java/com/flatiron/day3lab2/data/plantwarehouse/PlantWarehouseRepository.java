package com.flatiron.day3lab2.data.plantwarehouse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantWarehouseRepository extends JpaRepository<PlantWarehouse, Long> {

    PlantWarehouse findByName(String name);

}
