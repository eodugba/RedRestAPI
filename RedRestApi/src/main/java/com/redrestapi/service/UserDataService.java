package com.redrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redrestapi.dao.IUserDataDAO;
import com.redrestapi.entity.UserData;
@Service
public class UserDataService implements IUserDataService {
	@Autowired
	private IUserDataDAO userDataDAO;
	@Override
	public UserData getUserDataById(int userId) {
		UserData obj = userDataDAO.getUserDataById(userId);
		return obj;
	}
	@Override
	public UserData getUserDataByUserNamePassword(String userName, String password) {
		UserData obj = userDataDAO.getUserDataByUserNamePassword(userName,password);
		return obj;
	}
	@Override
	public List<UserData> getAllUserData(){
		return userDataDAO.getAllUserData();
	}
	@Override
	public synchronized boolean addUserData(UserData userData){
       if (userDataDAO.userDataExists(userData.getFirstName(), userData.getLastName())) {
    	   return false;
       } else {
    	   userDataDAO.addUserData(userData);
    	   return true;
       }
	}
	@Override
	public void updateUserData(UserData userData) {
		userDataDAO.updateUserData(userData);
	}
	@Override
	public void deleteUserData(int userDataId) {
		userDataDAO.deleteUserData(userDataId);
	}
}
