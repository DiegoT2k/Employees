package com.project.emsbackend.service;

import java.util.List;

import com.project.emsbackend.dto.EmployeeDto;

public interface EmployeeService {
    
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto deleteEmployee(Long employeeId);

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

}
