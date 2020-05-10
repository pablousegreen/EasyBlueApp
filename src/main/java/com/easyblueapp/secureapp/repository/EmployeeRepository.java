package com.easyblueapp.secureapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.easyblueapp.secureapp.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
