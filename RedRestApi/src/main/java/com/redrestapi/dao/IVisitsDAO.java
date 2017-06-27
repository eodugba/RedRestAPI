package com.redrestapi.dao;
import java.util.Date;
import java.util.List;

import com.redrestapi.entity.City;
import com.redrestapi.entity.State;
import com.redrestapi.entity.Visits;
import com.redrestapi.entity.Visitsv;
public interface IVisitsDAO {
    List<Visitsv> getAllVisits();
    Visits getVisitById(int visitId);
    List<City> getVisitsByUserCity(int userId);
    List<State> getVisitsByUserState(int userId);
    List<Visitsv> getVisitsByCity(int cityId);
    List<Visitsv> getVisitsByCity(int userid, int cityId);
    List<Visitsv> getVisitsByState(int userId, String state);
    void addVisit(Visits visit);
    void updateVisit(Visits visit);
    void deleteVisit(int visitId);
    void deleteVisit(int userid,int visitId);
    boolean VisitExists(int userId, int cityId, Date dateVisited);
    boolean VisitExists(int visitId);
}
 