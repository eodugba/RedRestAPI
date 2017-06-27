package com.redrestapi.service;

import java.util.List;

import com.redrestapi.entity.City;
import com.redrestapi.entity.State;
import com.redrestapi.entity.Visits;
import com.redrestapi.entity.Visitsv;


public interface IVisitsService {
	 Visits getVisitsById(int visitId);
     List<Visitsv> getAllVisits();
     List<City> getVisitsByUserCity(int userId);
     List<Visitsv> getVisitsByCity(int cityId);
     List<Visitsv> getVisitsByState(int userId, String state);
     List<State> getVisitsByUserState(int userId);
     List<Visitsv> getVisitsByCity(int userId, int cityId);
     boolean addVisit(Visits visit);
     void updateVisit(Visits visit);
     void deleteVisit(int userid,int visitId);
     void deleteVisit(int visitId);
}
