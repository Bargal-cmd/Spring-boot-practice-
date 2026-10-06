package com.pratice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.entity.Student;
import com.pratice.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	public Optional<Student> getStudentById(Integer id ){

		return repository.findById(id);
		
	}
      public List<Student> getStudentByName(String name){
    	  
    	  List<Student> ls =repository.findByName(name);
    	  return ls;
      }
      
      public Student getStudentByEmail(String email) {
    	   Student s = repository.findByEmail(email);
    	  return  s;
    	  
      }
      public List<Student> getStudentsByDept(String dept){
    	  List<Student> ls= repository.findByDept(dept);
    	return ls;
      }
      
      
}
