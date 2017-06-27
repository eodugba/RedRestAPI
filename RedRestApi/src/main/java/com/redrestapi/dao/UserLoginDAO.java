package com.redrestapi.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redrestapi.entity.UserLogin;
@Transactional
@Repository
public class UserLoginDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	
	public UserLogin getUserLoginById(int UserId) {
		return entityManager.find(UserLogin.class, UserId);
	}
	@SuppressWarnings("unchecked")
	
	public List<UserLogin> getAllUserLogin() {
		String hql = "FROM UserLogin ORDER BY user_id";
		return (List<UserLogin>) entityManager.createQuery(hql).getResultList();
	}	
	
	public void addUserLogin(UserLogin UserLogin) {
		entityManager.persist(UserLogin);
	}
	
	public void updateUserLogin(UserLogin UserLogin) {
		UserLogin artcl = getUserLoginById(UserLogin.getUserId());
		artcl.setUserName(UserLogin.getUserName());
		artcl.setPassword(UserLogin.getPassword());
		artcl.setUserId(UserLogin.getUserId());
		entityManager.flush();
	}
	
	public void deleteUserLogin(int UserLoginId) {
		entityManager.remove(getUserLoginById(UserLoginId));
	}
	
	public boolean UserLoginExists(String userName, String password) {
		String hql = "FROM  UserLogin WHERE userName= ? and password = ?";
		int count = entityManager.createQuery(hql).setParameter(1, userName)
		              .setParameter(2, password).getResultList().size();
		return count > 0 ? true : false;
	}
	public UserLogin getUserLogin(String userName, String password) {
		String hql = "FROM  UserLogin WHERE userName= ? and password = ?";
		return (UserLogin)entityManager.createQuery(hql).setParameter(1, userName)
		              .setParameter(2, password).getSingleResult();
	}
		
}
