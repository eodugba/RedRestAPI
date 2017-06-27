package com.redrestapi.service;

import java.util.List;

import com.redrestapi.entity.UserData;

public interface IUserDataService {
     List<UserData> getAllUserData();
     UserData getUserDataById(int userId);
     UserData getUserDataByUserNamePassword(String userName, String password);
     boolean addUserData(UserData userData);
     void updateUserData(UserData userData);
     void deleteUserData(int userId);
}
