package com.fatec.city.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.city.entities.City;

public interface CityRepository extends JpaRepository<City, Integer>{
    
}
