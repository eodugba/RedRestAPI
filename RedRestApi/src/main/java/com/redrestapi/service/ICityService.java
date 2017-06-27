package com.redrestapi.service;

import java.util.List;

import com.redrestapi.entity.City;

public interface ICityService {
     List<City> getAllCities();
     City getCityById(int cityId);
     List<City> getCityByState(String state);
     boolean addCity(City city);
     void updateCity(City city);
     void deleteCity(int cityId);
}
