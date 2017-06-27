package com.redrestapi.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redrestapi.entity.City;
@Transactional
@Repository
public class CityDAO implements ICityDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public City getCityById(int cityId) {
		return entityManager.find(City.class, cityId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCityByState(String state) {
		int state_length = state.length();
		String hql = "FROM City WHERE stateId= (select stateId from State WHERE ";
		if (state_length == 2)
		{
			hql =  hql +  "upper(abbreviation) = ?)";
		}
		else {
			hql = hql + "upper(name) = ?)";
		}
		return (List<City>) entityManager.createQuery(hql).setParameter(1, state.toUpperCase()).getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getAllCities() {
		String hql = "FROM City ORDER BY city_name";
		return (List<City>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addCity(City city) {
		entityManager.persist(city);
	}
	@Override
	public void updateCity(City city) {
		City artcl = getCityById(city.getCityId());
		artcl.setName(city.getName());
		artcl.setStateId(city.getStateId());
		artcl.setStatus(city.getStatus());
		artcl.setLatitude(city.getLatitude());
		artcl.setlongitude(city.getLongitude());
		artcl.setDateAdded(city.getDateAdded());
		artcl.setDateTimeAdded(city.getDateTimeAdded());
		artcl.setLastUpdated(city.getLastUpdated());
		entityManager.flush();
	}
	@Override
	public void deleteCity(int cityId) {
		entityManager.remove(getCityById(cityId));
	}
	@Override
	public boolean CityExists(String name, int stateId) {
		String hql = "FROM City WHERE city_name = ? and state_id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .setParameter(2, stateId).getResultList().size();
		return count > 0 ? true : false;
	}
}
