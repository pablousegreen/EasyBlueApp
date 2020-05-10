package com.easyblueapp.secureapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Employee")
public class Employee {
	
	@org.springframework.data.annotation.Id
	private String Id;
	private String department;
	private String name;
	private Integer salary;
	
	public Employee() {
		
	}
	
	
	public Employee(String department, String name, Integer salary) {
		super();
		this.department = department;
		this.name = name;
		this.salary = salary;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	

}
