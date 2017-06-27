package com.redrestapi.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="visit_view")
@Getter
@Setter
public class Visitsv implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="visit_id")
    private int visitId;  
	@Column(name="user_id")
    private int userId;  
	@Column(name="first_name")
    private String firstName;
	@Column(name="last_name")	
	private String lastName;
	@Column(name="city_id")	
	private int cityId;
	@Column(name="city_name")
    private String cityName;
	@Column(name="state_id")	
	private int stateId;
	@Column(name="state_name")
    private String stateName;
	@Column(name="abbreviation")	
	private String abbreviation;
	@Column(name="date_visited")	
	private Date dateVisited;
	@Column(name="date_time_added")	
	private Date dateTimeAdded;
	@Column(name="lastupdated")	
	private Date lastUpdated;
	
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int CityId) {
		this.cityId = CityId;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public Date getDateVisited() {
		return dateVisited;
	}
	public void setDateVisited(Date dateVisited) {
		this.dateVisited = dateVisited;
	}
	public Date getDateTimeAdded() {
		return dateTimeAdded;
	}
	public void setDateTimeAdded(Date dateTimeAdded) {
		this.dateTimeAdded = dateTimeAdded;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
} 
