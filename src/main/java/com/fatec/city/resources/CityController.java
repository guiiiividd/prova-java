package com.fatec.city.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.city.dto.CityRequest;
import com.fatec.city.dto.CityResponse;
import com.fatec.city.services.CityService;

@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private CityService cityService;
    
    @GetMapping
    public ResponseEntity<List<CityResponse>> getCities(){
        return ResponseEntity.ok(this.cityService.getCities());
    }

    @GetMapping("{id}")
    public ResponseEntity<CityResponse> getCityById(@PathVariable int id){
        return ResponseEntity.ok(this.cityService.getCityById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCity(@PathVariable int id, @Validated @RequestBody CityRequest city){
        this.cityService.updateCity(id, city);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCityById(@PathVariable int id){
        this.cityService.deleteCityById(id);
        return ResponseEntity.noContent().build();
    }
}
