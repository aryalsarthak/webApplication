package com.bway.springmvcdemo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springmvcdemo2.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
