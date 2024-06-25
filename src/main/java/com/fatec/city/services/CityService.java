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

    public void updateCity(int id, City city){
        try {
            City aux = this.cityRepository.getReferenceById(id);
            aux.setNome(city.getNome());
            aux.setEstado(city.getEstado());
            aux.setPopulacao(city.getPopulacao());
            aux.setPib(city.getPib());
            this.cityRepository.save(aux);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Cidade não cadastrada!");
        }
    }

    public void deleteCityById(int id){
        if(this.cityRepository.existsById(id)){
            this.cityRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Cidade não cadastrada!");
        }
    }
}
