package com.mthree.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int studentId;
	private String name;
	private String dept;
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	
	public Student(int studentId, String name, String dept, Address address) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.dept = dept;
		this.address = address;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
	
		this.dept = dept;
	}
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", dept=" + dept + ", address=" + address + "]";
	}
	
	
	
	
}
