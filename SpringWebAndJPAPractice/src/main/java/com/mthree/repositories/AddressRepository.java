package com.mthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mthree.models.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{
	
	

}
