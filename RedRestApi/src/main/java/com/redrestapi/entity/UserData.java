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
@Table(name="userdata")
@Getter
@Setter
public class UserData implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
    private int userId;  
	@Column(name="first_name")
    private String firstName;
	@Column(name="last_name")	
	private String lastName;
	@Column(name="date_added")	
	private Date dateAdded;
	@Column(name="date_time_added")	
	private Date dateTimeAdded;
	@Column(name="lastupdated")	
	private Date lastUpdated;
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
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
