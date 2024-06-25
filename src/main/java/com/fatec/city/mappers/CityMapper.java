package com.fatec.city.mappers;

import com.fatec.city.dto.CityRequest;
import com.fatec.city.dto.CityResponse;
import com.fatec.city.entities.City;

public class CityMapper {
    public static City toEntity(CityRequest request){
        City city = new City();
        city.setNome(request.nome());
        city.setEstado(request.estado());
        city.setPopulacao(request.populacao());
        city.setPib(request.pib());
        return city;
    }

    public static CityResponse toDTO(City city){
        return new CityResponse(city.getId(), city.getNome(), city.getEstado(), city.getPopulacao(), city.getPib());
    }
}
