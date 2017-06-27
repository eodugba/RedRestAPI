package com.redrestapi.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.redrestapi.entity.City;

public class RestClientUtil {
    public void getCityByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/City/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<City> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, City.class, 1);
        City City = responseEntity.getBody();
        System.out.println("Id:"+City.getCityId()+", Name:"+City.getName()
                 +", StateId:"+City.getStateId());      
    }
	public void getAllCitysDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/Cities";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<City[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, City[].class);
        City[] Citys = responseEntity.getBody();
        for(City City : Citys) {
              System.out.println("Id:"+City.getCityId()+", Title:"+City.getName()
                      +", StateId: "+City.getStateId());
        }
    }
    public void addCityDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/City";
	    City objCity = new City();
	    objCity.setName("Spring REST Security using Hibernate");
	    objCity.setStateId(1);
        HttpEntity<City> requestEntity = new HttpEntity<City>(objCity, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateCityDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/City";
	    City objCity = new City();
	    objCity.setCityId(1);
	    objCity.setName("Update:Java Concurrency");
	    objCity.setStateId(1);
        HttpEntity<City> requestEntity = new HttpEntity<City>(objCity, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteCityDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/City/{id}";
        HttpEntity<City> requestEntity = new HttpEntity<City>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getCityByIdDemo();
    	util.getAllCitysDemo();
    	//util.addCityDemo();
    	//util.updateCityDemo();
    	//util.deleteCityDemo();
    }    
}
