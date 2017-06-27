package com.redrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redrestapi.dao.ICityDAO;
import com.redrestapi.entity.City;
@Service
public class CityService implements ICityService {
	@Autowired
	private ICityDAO CityDAO;
	@Override
	public City getCityById(int cityId) {
		City obj = CityDAO.getCityById(cityId);
		return obj;
	}	
	@Override
	public List<City> getCityByState(String state) {
		return CityDAO.getCityByState(state);
	}	
	@Override
	public List<City> getAllCities(){
		return CityDAO.getAllCities();
	}
	@Override
	public synchronized boolean addCity(City city){
       if (CityDAO.CityExists(city.getName(), city.getStateId())) {
    	   return false;
       } else {
    	   CityDAO.addCity(city);
    	   return true;
       }
	}
	@Override
	public void updateCity(City city) {
		CityDAO.updateCity(city);
	}
	@Override
	public void deleteCity(int cityId) {
		CityDAO.deleteCity(cityId);
	}
}
