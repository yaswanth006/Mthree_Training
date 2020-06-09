package com.mthree.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.models.UserDetails;
import com.mthree.models.Vehicle;
import com.mthree.services.MyService;

@RestController
public class MyRestController {

	@Autowired
	MyService myservice;
	
	@GetMapping("/getUsers")
	public List<UserDetails> getUserDetails()
	{
		return myservice.getUsers();
	}
	
	@GetMapping("/getVehicles")
	public List<Vehicle> getVehicleDetails()
	{
		return myservice.getVehicles();
	}
	
	@PostMapping("/uploadUsers")
	public UserDetails uploadUserDetails(@RequestBody UserDetails user)
	{
		return myservice.registerUser(user);
	}
	
	@PostMapping("/uploadVehicles")
	public Vehicle uploadVehicleDetails(@RequestBody Vehicle vehicle)
	{
		return myservice.registerVehicle(vehicle);
	}
}
