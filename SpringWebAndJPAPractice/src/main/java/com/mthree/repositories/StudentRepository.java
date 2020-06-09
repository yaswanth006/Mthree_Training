package com.mthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
 
	
	
}
