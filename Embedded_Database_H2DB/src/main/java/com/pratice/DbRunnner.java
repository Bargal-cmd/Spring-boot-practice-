package com.pratice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pratice.entity.Employee;
import com.pratice.repository.EmployeeRepository;
@Component
public class DbRunnner  implements CommandLineRunner {
@Autowired
	
	private EmployeeRepository repo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee employee =new Employee(123, "Rahul", 4556.0);
		
		repo.save(employee);
		
		
	}

}
