package com.example.springrestapi.service;

import com.example.springrestapi.entity.Employee;
import com.example.springrestapi.error.EmployeeNotFoundException;
import com.example.springrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if(!employee.isPresent()) {
            throw new EmployeeNotFoundException("Employee Not Available");
        }
        return employee.get();
    }


    @Override
    public void updateEmployee(Long employeeId, String firstName, String lastName, String email) {
        Employee employee = employeeRepository.findById(employeeId).get();

        if(firstName != null && lastName !=null && email != null) {
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
        }

        employeeRepository.save(employee);
    }

    @Override
    public Employee UpdateEmployeeV2(Long employeeId, Employee employee) {
        Employee employeeDB = employeeRepository.findById(employeeId).get();

        if (Objects.nonNull(employee.getFirstName())) {
            employeeDB.setFirstName(employee.getFirstName());
        }

        if (Objects.nonNull(employee.getLastName())) {
            employeeDB.setLastName(employee.getLastName());
        }

        if (Objects.nonNull(employee.getEmail())) {
            employeeDB.setEmail(employee.getEmail());
        }

        return employeeRepository.save(employeeDB);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public String numberOfEmployees() {
        Long numberOfEmployees;
        numberOfEmployees = employeeRepository.count();
        return "Number of employees: " + numberOfEmployees;
    }


}
