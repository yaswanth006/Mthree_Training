package com.mthree.models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Vehicle {

	@Id
	private int vehicleId;
	private String vehicleName;
	
	@ManyToMany
	
	@JsonManagedReference
	private List<UserDetails> users=new ArrayList<>();
	
	Vehicle(){}

	

	public Vehicle(int vehicleid, String vehicleName, List<UserDetails> users) {
		super();
		this.vehicleId = vehicleid;
		this.vehicleName = vehicleName;
		this.users = users;
	}



	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}



	public List<UserDetails> getUsers() {
		return users;
	}



	public void setUsers(List<UserDetails> users) {
		this.users = users;
	}



	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", users=" + users + "]";
	}

	
	
	
	
	
}