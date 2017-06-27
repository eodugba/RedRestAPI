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

import com.redrestapi.entity.UserLogin;
import com.redrestapi.service.UserLoginService;

@Controller
@RequestMapping("/")
public class UserLoginController {
	@Autowired
	private UserLoginService UserLoginService;
	@GetMapping("UserLogin/{id}")
	public ResponseEntity<UserLogin> getUserLoginById(@PathVariable("id") Integer id) {
		UserLogin UserLogin = UserLoginService.getUserLoginById(id);
		return new ResponseEntity<UserLogin>(UserLogin, HttpStatus.OK);
	}
	@GetMapping("UserLogin/user/{userName}/password/{password}")
	public ResponseEntity<UserLogin> getUserLogin(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		UserLogin UserLogin = UserLoginService.getUserLogin(userName, password);
		return new ResponseEntity<UserLogin>(UserLogin, HttpStatus.OK);
	}
	@GetMapping("UserLogin")
	public ResponseEntity<List<UserLogin>> getAllUserLogin() {
		List<UserLogin> list = UserLoginService.getAllUserLogin();
		return new ResponseEntity<List<UserLogin>>(list, HttpStatus.OK);
	}
	@PostMapping("UserLogin")
	public ResponseEntity<Void> addUserLogin(@RequestBody UserLogin UserLogin , UriComponentsBuilder builder) {
        boolean flag = UserLoginService.addUserLogin(UserLogin);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/UserLogin/{id}").buildAndExpand(UserLogin.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("UserLogin")
	public ResponseEntity<UserLogin> updateUserLogin(@RequestBody UserLogin UserLogin) {
		UserLoginService.updateUserLogin(UserLogin);
		return new ResponseEntity<UserLogin>(UserLogin, HttpStatus.OK);
	}
	@DeleteMapping("UserLogin/{id}")
	public ResponseEntity<Void> deleteUserLogin(@PathVariable("id") Integer id) {
		UserLoginService.deleteUserLogin(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 