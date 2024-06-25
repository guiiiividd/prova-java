package com.fatec.city.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.city.entities.City;
import com.fatec.city.repositories.CityRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    
    public List<City> getCities(){
        return cityRepository.findAll();
    }

    public City getCityById(int id){
        return cityRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Cidade não cadastrada!")
        );
    }
}
