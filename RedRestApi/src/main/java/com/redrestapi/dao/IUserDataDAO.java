package com.redrestapi.dao;
import java.util.List;

import com.redrestapi.entity.UserData;
public interface IUserDataDAO {
    List<UserData> getAllUserData();
    UserData getUserDataById(int UserId);
    UserData getUserDataByUserNamePassword(String userName, String password);
    void addUserData(UserData userData);
    void updateUserData(UserData userData);
    void deleteUserData(int userId);
    boolean userDataExists(String name, String i);
}
 