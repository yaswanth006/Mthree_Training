package com.mthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mthree.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
	

}
