package com.fatec.city.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.city.entities.City;
import com.fatec.city.services.CityService;

@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private CityService cityService;
    
    @GetMapping
    public List<City> getCities(){
        return this.cityService.getCities();
    }

    @GetMapping("{id}")
    public City getCityById(@PathVariable int id){
        return this.cityService.getCityById(id);
    }

    @PutMapping("{id}")
    public void updateCity(@PathVariable int id, @RequestBody City city){
        this.cityService.updateCity(id, city);
    }

    @DeleteMapping("{id}")
    public void deleteCityById(@PathVariable int id){
        this.cityService.deleteCityById(id);
    }
}
