package com.fatec.city.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.city.dto.CityRequest;
import com.fatec.city.dto.CityResponse;
import com.fatec.city.entities.City;
import com.fatec.city.mappers.CityMapper;
import com.fatec.city.repositories.CityRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    
    public List<CityResponse> getCities(){
        List <City> cities = cityRepository.findAll();
        return cities.stream().map(c -> CityMapper.toDTO(c)).collect(Collectors.toList());
    }

    public CityResponse getCityById(int id){
        City city = cityRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Cidade não cadastrada!")
        );
        return CityMapper.toDTO(city);
    }

    public void updateCity(int id, CityRequest city){
        try {
            City aux = this.cityRepository.getReferenceById(id);
            aux.setNome(city.nome());
            aux.setEstado(city.estado());
            aux.setPopulacao(city.populacao());
            aux.setPib(city.pib());
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
