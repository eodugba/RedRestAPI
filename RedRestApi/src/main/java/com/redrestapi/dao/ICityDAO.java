package com.redrestapi.dao;
import java.util.List;

import com.redrestapi.entity.City;
public interface ICityDAO {
    List<City> getAllCities();
    City getCityById(int CityId);
    List<City> getCityByState(String state);
    void addCity(City City);
    void updateCity(City City);
    void deleteCity(int CityId);
    boolean CityExists(String name, int i);
}
 