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
@Table(name="state")
@Getter
@Setter
public class State implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="state_id")
    private int stateId;  
	@Column(name="state_name")
    private String name;
	@Column(name="abbreviation")	
	private String abbreviation;
	@Column(name="date_added")	
	private Date dateAdded;
	@Column(name="date_time_added")	
	private Date dateTimeAdded;
	@Column(name="lastupdated")	
	private Date lastUpdated;
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int StateId) {
		this.stateId = StateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String status) {
		this.abbreviation= status;
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
