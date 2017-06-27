package com.redrestapi.dao;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redrestapi.entity.City;
import com.redrestapi.entity.State;
import com.redrestapi.entity.Visits;
import com.redrestapi.entity.Visitsv;

@Transactional
@Repository
public class VisitsDAO implements IVisitsDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	public Visits getVisitById(int visitId) {
		return entityManager.find(Visits.class, visitId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getVisitsByUserCity(int userId) {
		String hql = "FROM City WHERE cityId in (Select cityId from Visitsv WHERE userId = ? ) ORDER BY name";
		return (List<City>) entityManager.createQuery(hql).setParameter(1, userId).getResultList();
	}	
	@SuppressWarnings("unchecked")
	@Override
	public List<State> getVisitsByUserState(int userId) {
		String hql = "FROM State WHERE stateId in (Select stateId from Visitsv WHERE userId = ? ) ORDER BY name";
		return (List<State>) entityManager.createQuery(hql).setParameter(1, userId).getResultList();
	}	
	@SuppressWarnings("unchecked")
	@Override
	public List<Visitsv> getVisitsByCity(int cityId) {
		return (List<Visitsv>)entityManager.find(Visitsv.class, cityId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Visitsv> getAllVisits() {
		String hql = "FROM Visitsv ORDER BY userId, cityId";
		return (List<Visitsv>) entityManager.createQuery(hql).getResultList();
	}	
	@SuppressWarnings("unchecked")
	@Override
	public List<Visitsv> getVisitsByState(int userId, String state) {
		int state_length = state.length();
		String hql = "FROM Visitsv WHERE userId = ?  AND  ";
		if (state_length == 2)
		{
			hql =  hql +  "upper(abbreviation) = ?";
		}
		else {
			hql = hql + "upper(name) = ?";
		}
		return (List<Visitsv>) entityManager.createQuery(hql).setParameter(1, userId).setParameter(2,state.toUpperCase()).getResultList();
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Visitsv> getVisitsByCity(int userId, int cityId) {
		String hql = "FROM Visitsv WHERE userId = ? and cityId = ? ORDER BY userId, cityId";
		return (List<Visitsv>) entityManager.createQuery(hql).setParameter(1, userId).setParameter(2,cityId).getResultList();
	}	
	
	@Override
	public void addVisit(Visits visit) {
		entityManager.persist(visit);
	}
	@Override
	public void updateVisit(Visits visit) {
		Visits artcl = getVisitById(visit.getVisitId());
		artcl.setUserId(visit.getUserId());
		artcl.setCityId(visit.getCityId());
		artcl.setDateVisited(visit.getDateVisited());
		artcl.setDateTimeAdded(visit.getDateTimeAdded());
		artcl.setLastUpdated(visit.getLastUpdated());
		entityManager.flush();
	}
	@Override
	public void deleteVisit(int visitId) {
		entityManager.remove(getVisitById(visitId));
	}
	@Override
	public void deleteVisit(int userId ,int visitId) {
		entityManager.remove(getVisitById(visitId));
	}
	@Override
	public boolean VisitExists(int userId, int cityId, Date dateVisited) {
		String hql = "FROM Visits WHERE userId = ? and cityId = ? and dateVisited = ?";
		int count = entityManager.createQuery(hql).setParameter(1, userId)
		              .setParameter(2, cityId).setParameter(2, dateVisited).getResultList().size();
		return count > 0 ? true : false;
	}
	
	public boolean VisitExists(int visitId) {
		String hql = "FROM Visits WHERE visitId = ?";
		int count = entityManager.createQuery(hql).setParameter(1, visitId).getResultList().size();
		return count > 0 ? true : false;
	}
	
}
