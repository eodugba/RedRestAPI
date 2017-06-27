package com.redrestapi.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redrestapi.entity.UserData;

@Transactional
@Repository
public class UserDataDAO implements IUserDataDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public UserData getUserDataById(int UserId) {
		return entityManager.find(UserData.class, UserId);
	}
	@Override
	public UserData getUserDataByUserNamePassword(String userName, String password){
		
		String hql = "FROM  UserData WHERE userId = (select userId from UserLogin where userName= ? and password = ?)";
		return (UserData)entityManager.createQuery(hql).setParameter(1, userName)
		              .setParameter(2, password).getSingleResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserData> getAllUserData() {
		String hql = "FROM UserData ORDER BY user_id";
		return (List<UserData>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addUserData(UserData userData) {
		entityManager.persist(userData);
	}
	@Override
	public void updateUserData(UserData userData) {
		UserData artcl = getUserDataById(userData.getUserId());
		artcl.setFirstName(userData.getFirstName());
		artcl.setLastName(userData.getLastName());
		artcl.setUserId(userData.getUserId());
		artcl.setDateAdded(userData.getDateAdded());
		artcl.setDateTimeAdded(userData.getDateTimeAdded());
		artcl.setLastUpdated(userData.getLastUpdated());
		entityManager.flush();
	}
	@Override
	public void deleteUserData(int UserDataId) {
		entityManager.remove(getUserDataById(UserDataId));
	}
	@Override
	public boolean userDataExists(String name, String UserDataId) {
		String hql = "FROM  UserData WHERE first_name= ? and last_name = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .setParameter(2, UserDataId).getResultList().size();
		return count > 0 ? true : false;
	}
}
