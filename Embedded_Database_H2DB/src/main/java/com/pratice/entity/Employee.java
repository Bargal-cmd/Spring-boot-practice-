package com.pratice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Id
	 Integer empId;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	private String empName;
	private Double salary;
	public Employee(Integer empId, String empName, Double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}
	

}
