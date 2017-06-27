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
@Table(name="city")
@Getter
@Setter
public class City implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="city_id")
    private int cityId;  
	@Column(name="city_name")
    private String name;
	@Column(name="state_id")	
	private int stateId;
	@Column(name="status")	
	private String status;
	@Column(name="latitude")	
	private long latitude;
	@Column(name="longitude")	
	private long longitude;
	@Column(name="date_added")	
	private Date dateAdded;
	@Column(name="date_time_added")	
	private Date dateTimeAdded;
	@Column(name="lastupdated")	
	private Date lastUpdated;
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int CityId) {
		this.cityId = CityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setlongitude(long longitude) {
		this.longitude = longitude;
	}
	
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
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
} 
