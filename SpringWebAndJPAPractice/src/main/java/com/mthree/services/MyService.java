package com.mthree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.models.Address;
import com.mthree.models.Student;
import com.mthree.models.UserDetails;
import com.mthree.models.Vehicle;
import com.mthree.repositories.AddressRepository;
import com.mthree.repositories.StudentRepository;
import com.mthree.repositories.UserRepository;
import com.mthree.repositories.VehicleRepository;
@Service
public class MyService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Student registerStudent(Student s)
	{
		return studentRepository.save(s);
		//returns the new entity created (Spring framework creates class called studentrepository and provides implemented methods here save method when instance of the user interface created)
		
		
	}
	public Address registerAddress(Address a)
	{
		return addressRepository.save(a);
	}
	
	public UserDetails registerUser(UserDetails user)
	{
		return userRepository.save(user);
	}
	
	public Vehicle registerVehicle(Vehicle vehicle)
	{
		return vehicleRepository.save(vehicle);
	}
	
	public List <UserDetails> getUsers()
	{
		return userRepository.findAll();
	}
	
	public List <Vehicle> getVehicles()
	{
		return vehicleRepository.findAll();
	}
	

	
}
