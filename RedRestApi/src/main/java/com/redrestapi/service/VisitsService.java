package com.redrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redrestapi.dao.IVisitsDAO;
import com.redrestapi.entity.City;
import com.redrestapi.entity.State;
import com.redrestapi.entity.Visits;
import com.redrestapi.entity.Visitsv;

@Service
public class VisitsService implements IVisitsService {
	@Autowired
	private IVisitsDAO VisitsDAO;
	@Override
	public Visits getVisitsById(int visitId) {
		Visits obj = VisitsDAO.getVisitById(visitId);
		return obj;
	}	
	@Override
	public List<City> getVisitsByUserCity(int userId) { 
		return VisitsDAO.getVisitsByUserCity(userId);
	}	
	@Override
	public List<State> getVisitsByUserState(int userId) { 
		return VisitsDAO.getVisitsByUserState(userId);
	}	
	@Override
	public List<Visitsv> getVisitsByCity(int cityId) {
		return (List<Visitsv>)VisitsDAO.getVisitsByCity(cityId);
	}	
	@Override
	public List<Visitsv> getVisitsByState(int userId, String state) {
		return (List<Visitsv>)VisitsDAO.getVisitsByState(userId, state);
	}
	
	@Override
	public List<Visitsv> getVisitsByCity(int userId, int cityId) {
		return (List<Visitsv>)VisitsDAO.getVisitsByCity(userId, cityId);
	}
	@Override
	public List<Visitsv> getAllVisits(){
		return VisitsDAO.getAllVisits();
	}
	@Override
	public synchronized boolean addVisit(Visits visit){
       if (VisitsDAO.VisitExists(visit.getVisitId())) {
    	   return false;
       } else {
    	   VisitsDAO.addVisit(visit);
    	   return true;
       }
	}
	@Override
	public void updateVisit(Visits visit) {
		VisitsDAO.updateVisit(visit);
	}
	@Override
	public void deleteVisit(int visitId) {
		VisitsDAO.deleteVisit(visitId);
	}
	@Override
	public void deleteVisit(int userid,int visitId) {
		VisitsDAO.deleteVisit(userid,visitId);
	}
}
