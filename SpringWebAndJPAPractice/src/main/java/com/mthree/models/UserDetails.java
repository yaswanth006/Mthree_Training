package com.mthree.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class UserDetails {

	

	@Id
	private int userId;
	private String userName;
	
	@ManyToMany(mappedBy="users")
	@JsonBackReference
	private List<Vehicle> vehicles=new ArrayList<>();
	public UserDetails(){}

	public UserDetails(int userId, String userName, List<Vehicle> vehicles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.vehicles = vehicles;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", vehicles=" + vehicles + "]";
	}
	
	
}
