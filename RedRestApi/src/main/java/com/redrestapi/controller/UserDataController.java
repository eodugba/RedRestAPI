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

import com.redrestapi.entity.UserData;
import com.redrestapi.service.IUserDataService;

@Controller
@RequestMapping("/")
public class UserDataController {
	@Autowired
	private IUserDataService UserDataService;
	@GetMapping("userdata/{id}")
	public ResponseEntity<UserData> getUserDataById(@PathVariable("id") Integer id) {
		UserData userData = UserDataService.getUserDataById(id);
		return new ResponseEntity<UserData>(userData, HttpStatus.OK);
	}
	@GetMapping("userdata/user/{userName}/password/{password}")
	public ResponseEntity<UserData> getUserDataByUserNamePassword(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		UserData userData = UserDataService.getUserDataByUserNamePassword(userName, password);
		return new ResponseEntity<UserData>(userData, HttpStatus.OK);
	}
	@GetMapping("userdata")
	public ResponseEntity<List<UserData>> getAllUserData() {
		List<UserData> list = UserDataService.getAllUserData();
		return new ResponseEntity<List<UserData>>(list, HttpStatus.OK);
	}
	@PostMapping("userdata")
	public ResponseEntity<Void> addUserData(@RequestBody UserData userData , UriComponentsBuilder builder) {
        boolean flag = UserDataService.addUserData(userData);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/UserData/{id}").buildAndExpand(userData.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("userdata")
	public ResponseEntity<UserData> updateUserData(@RequestBody UserData userData) {
		UserDataService.updateUserData(userData);
		return new ResponseEntity<UserData>(userData, HttpStatus.OK);
	}
	@DeleteMapping("userdata/{id}")
	public ResponseEntity<Void> deleteUserData(@PathVariable("id") Integer id) {
		UserDataService.deleteUserData(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 