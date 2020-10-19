package com.flatiron.day3lab2.data.plant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    Plant findByName(String name);

}
