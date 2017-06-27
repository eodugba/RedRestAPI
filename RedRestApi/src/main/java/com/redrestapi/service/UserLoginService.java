package com.redrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redrestapi.dao.UserLoginDAO;
import com.redrestapi.entity.UserLogin;
@Service
public class UserLoginService {
	@Autowired
	private UserLoginDAO UserLoginDAO;
	
	public UserLogin getUserLoginById(int userId) {
		UserLogin obj = UserLoginDAO.getUserLoginById(userId);
		return obj;
	}
	public UserLogin getUserLogin(String userName, String password) {
		UserLogin obj = UserLoginDAO.getUserLogin(userName, password);
		return obj;
	}	
	
	public List<UserLogin> getAllUserLogin(){
		return UserLoginDAO.getAllUserLogin();
	}
	
	public synchronized boolean addUserLogin(UserLogin UserLogin){
       if (UserLoginDAO.UserLoginExists(UserLogin.getUserName(), UserLogin.getPassword())) {
    	   return false;
       } else {
    	   UserLoginDAO.addUserLogin(UserLogin);
    	   return true;
       }
	}
	
	public void updateUserLogin(UserLogin UserLogin) {
		UserLoginDAO.updateUserLogin(UserLogin);
	}
	
	public void deleteUserLogin(int UserLoginId) {
		UserLoginDAO.deleteUserLogin(UserLoginId);
	}
}
