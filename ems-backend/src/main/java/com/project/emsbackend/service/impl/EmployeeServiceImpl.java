package com.project.emsbackend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.emsbackend.dto.EmployeeDto;
import com.project.emsbackend.entity.Employee;
import com.project.emsbackend.exception.ResourceNotFoundException;
import com.project.emsbackend.mapper.EmployeeMapper;
import com.project.emsbackend.repository.EmployeeRepository;
import com.project.emsbackend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> 
                new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));
        
        return EmployeeMapper.mapToEmployeeDto(employee);

    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> lista = employeeRepository.findAll();
        
        return EmployeeMapper.mapToEmployeeDto(lista);
    }


    @Override
    public EmployeeDto deleteEmployee(Long employeeId) {
        
        Employee e = employeeRepository.findById(employeeId)
            .orElseThrow(() -> 
                new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));

        employeeRepository.delete(e);
        
        return EmployeeMapper.mapToEmployeeDto(e);
    }


    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        
        Employee e = employeeRepository.findById(employeeId)
            .orElseThrow(() ->
                new ResourceNotFoundException("Not exist"));

        e.setFirstName(updatedEmployee.getFirstName());
        e.setLastName(updatedEmployee.getLastName());
        e.setEmail(updatedEmployee.getEmail());

        employeeRepository.save(e);

        return EmployeeMapper.mapToEmployeeDto(e);
    }


}
