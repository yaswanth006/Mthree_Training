package com.mthree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.mthree.models.Address;
import com.mthree.models.Student;
import com.mthree.models.UserDetails;
import com.mthree.services.MyService;

@Controller
public class MyController {

	@Autowired
	private MyService myService;
	
	@GetMapping(path="/")
	public String welcome()
	{
		return "Registration";
	}
	@PostMapping("/registerStudent")
	public ModelAndView register(@RequestBody Student s)
	{
		ModelAndView mv = new ModelAndView();
		
		Student s1=myService.registerStudent(s);
		mv.addObject("StudentInstance",s1);
		mv.setViewName("RegistrationSucess");
		return mv;
		
		//return "Registration";
	}
	
	@PostMapping("/registerAddress")
	public void registerAddress(@RequestBody Address address)
	{
		Address addr=myService.registerAddress(address);
		System.out.println(addr);
	}
	
	@PostMapping("/registerUser")
	public void registerUser(@RequestBody UserDetails user)
	{
		UserDetails users=myService.registerUser(user);
		System.out.println(users);
	}
	
	
}
