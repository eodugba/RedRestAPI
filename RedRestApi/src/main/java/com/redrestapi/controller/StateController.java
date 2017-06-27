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

import com.redrestapi.entity.State;
import com.redrestapi.service.IStateService;

@Controller
@RequestMapping("/")
public class StateController {
	@Autowired
	private IStateService stateService;
	
	//Get a state by is primary key
	@GetMapping("state/{id}")
	public ResponseEntity<State> getStateById(@PathVariable("id") Integer id) {
		State state = stateService.getStateById(id);
		return new ResponseEntity<State>(state, HttpStatus.OK);
	}
	//Get all states in the database
	@GetMapping("state")
	public ResponseEntity<List<State>> getAllState() {
		List<State> list = stateService.getAllStates();
		return new ResponseEntity<List<State>>(list, HttpStatus.OK);
	}
	//Insert a new state into the database
	@PostMapping("state")
	public ResponseEntity<Void> addState(@RequestBody State state , UriComponentsBuilder builder) {
        boolean flag = stateService.addState(state);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/State/{id}").buildAndExpand(state.getStateId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//Update a state information
	@PutMapping("state")
	public ResponseEntity<State> updateState(@RequestBody State state) {
		stateService.updateState(state);
		return new ResponseEntity<State>(state, HttpStatus.OK);
	}
	//Remove a state
	@DeleteMapping("state/{id}")
	public ResponseEntity<Void> deleteState(@PathVariable("id") Integer id) {
		stateService.deleteState(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 