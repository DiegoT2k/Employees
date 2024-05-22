package com.project.emsbackend.mapper;

import java.util.ArrayList;
import java.util.List;

import com.project.emsbackend.dto.EmployeeDto;
import com.project.emsbackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee e){
        return new EmployeeDto(e.getId(),
            e.getFirstName(),
            e.getLastName(),
            e.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto e){
        return new Employee(
            e.getId(),
            e.getFirstName(),
            e.getLastName(),
            e.getEmail()
        );
    }

    public static List<EmployeeDto> mapToEmployeeDto(List<Employee> l){
        
        List<EmployeeDto> lista = new ArrayList<>();

        for(Employee e : l){
            lista.add(mapToEmployeeDto(e));
        }

        return lista;
    }

}
