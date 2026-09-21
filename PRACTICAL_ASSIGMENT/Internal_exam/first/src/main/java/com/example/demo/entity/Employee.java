package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String empName;
	private String department;
	private double salary;
	
	public Employee()
	{
		
	}
	
	
	public Employee(Integer empId,String empName,String department,double salary)
	{
		this.empId=empId;
		this.empName=empName;
		this.department=department;
		this.salary=salary;
		
	}
	

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


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	
	
}