package com.example.springrestapi.service;

import com.example.springrestapi.entity.Employee;
import com.example.springrestapi.error.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> fetchEmployeeList();

    Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException;

    void updateEmployee(Long employeeId, String firstName, String lastName, String email);

    Employee UpdateEmployeeV2(Long employeeId, Employee employee);

    void deleteEmployeeById(Long employeeId);

    String numberOfEmployees();
}
