package com.redrestapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.redrestapi.entity.City;
import com.redrestapi.service.ICityService;

@Controller
@RequestMapping("/")
public class CityController {
	@Autowired
	private ICityService cityService;
	
	//get a city by its id
	@GetMapping("city/{id}")
	public ResponseEntity<City> getCityById(@PathVariable("id") Integer id) {
		City city = cityService.getCityById(id);
		return new ResponseEntity<City>(city, HttpStatus.OK);
	}
	//get all cities in a state
	@GetMapping("state/{state}/cities")
	public ResponseEntity<List<City>> getCityByState(@PathVariable("state") String state) {
		List<City> list  = cityService.getCityByState(state);
		return new ResponseEntity<List<City>>(list, HttpStatus.OK);
	}
	//get all cities in the database
	@GetMapping("city")
	public ResponseEntity<List<City>> getAllCity() {
		List<City> list = cityService.getAllCities();
		return new ResponseEntity<List<City>>(list, HttpStatus.OK);
	}
	//Insert a new City
	@PostMapping("city")
	public ResponseEntity<Void> addCity(@RequestBody City city , UriComponentsBuilder builder) {
        boolean flag = cityService.addCity(city);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/city/{id}").buildAndExpand(city.getCityId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	//Update a given city
	@PutMapping("city")
	public ResponseEntity<City> updateCity(@RequestBody City city) {
		cityService.updateCity(city);
		return new ResponseEntity<City>(city, HttpStatus.OK);
	}
	
	//Remove a city
	@DeleteMapping("city/{id}")
	public ResponseEntity<Void> deleteCity(@PathVariable("id") Integer id) {
		cityService.deleteCity(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 