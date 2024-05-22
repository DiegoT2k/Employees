package com.project.emsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.emsbackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{ 
}
