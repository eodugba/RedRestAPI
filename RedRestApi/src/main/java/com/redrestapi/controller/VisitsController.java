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
//import org.springframework.web.bind.annotation.ExceptionHandler;

import com.redrestapi.entity.City;
import com.redrestapi.entity.State;
import com.redrestapi.entity.Visits;
import com.redrestapi.entity.Visitsv;
import com.redrestapi.service.IVisitsService;
//import com.redrestapi.message.handler.*;

@Controller
@RequestMapping("/")
public class VisitsController {

	@Autowired
	private IVisitsService visitsService;
	/*Retrieve a given Visit*/
	@GetMapping("visit/{id}")
	public ResponseEntity<Visits> getVisitsById(@PathVariable("id") Integer id) {
		Visits visit = visitsService.getVisitsById(id);
		return new ResponseEntity<Visits>(visit, HttpStatus.OK);
	}
	/* List All cities visited by a given User  */
	@GetMapping("user/{user}/visits")
	public ResponseEntity<List<City>> getVisitsByUserCity(@PathVariable("user") int user) {
		List<City> list  = visitsService.getVisitsByUserCity(user);
		return new ResponseEntity<List<City>>(list, HttpStatus.OK);
	}
	/* List All states visited by a given user*/
	@GetMapping("user/{user}/visits/states")
	public ResponseEntity<List<State>> getVisitsByUserState(@PathVariable("user") int user) {
		List<State> list  = visitsService.getVisitsByUserState(user);
		return new ResponseEntity<List<State>>(list, HttpStatus.OK);
	}
	/* List All visits to a given city */
	@GetMapping("visits/city/{city}")
	public ResponseEntity<List<Visitsv>> getVisitsByCity(@PathVariable("city") int city) {
		List<Visitsv> list  = visitsService.getVisitsByCity(city);
		return new ResponseEntity<List<Visitsv>>(list, HttpStatus.OK);
	}
	/* Get all visits by a user to a given city */
	@GetMapping("user/{user}/visits/city/{city}")
	public ResponseEntity<List<Visitsv>> getVisitsByCity(@PathVariable("user") int user, @PathVariable("city") int city ) {
		List<Visitsv> list  = visitsService.getVisitsByCity(user,city);
		return new ResponseEntity<List<Visitsv>>(list, HttpStatus.OK);
	}
	/* Get all visits*/
	@GetMapping("visit")
	public ResponseEntity<List<Visitsv>> getAllVisits() {
		List<Visitsv> list = visitsService.getAllVisits();
		return new ResponseEntity<List<Visitsv>>(list, HttpStatus.OK);
	}
	/* Post a visit */
	@PostMapping("visit")
	public ResponseEntity<Void> addVisit(@RequestBody Visits visit , UriComponentsBuilder builder) {
        boolean flag = visitsService.addVisit(visit);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/visit/{id}").buildAndExpand(visit.getVisitId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	/*Update a Visit*/
	@PutMapping("visit")
	public ResponseEntity<Visits> updateCity(@RequestBody Visits visit) {
		visitsService.updateVisit(visit);
		return new ResponseEntity<Visits>(visit, HttpStatus.OK);
	}
	/*Delete a given visit*/
	@DeleteMapping("visit/{id}")
	public ResponseEntity<Void> deleteCity(@PathVariable("id") Integer id) {
		visitsService.deleteVisit(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	/*Delete a given visit*/
	@DeleteMapping("user/{userId}/visit/{id}")
	public ResponseEntity<Void> deleteCity(@PathVariable("UserId") Integer userId, @PathVariable("id") Integer id) {
		visitsService.deleteVisit(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
} 