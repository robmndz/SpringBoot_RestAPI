package com.example.springrestapi.controller;

import com.example.springrestapi.entity.Employee;
import com.example.springrestapi.error.EmployeeNotFoundException;
import com.example.springrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // POST - / api / employees - Create a new employee
    // Postman
    @PostMapping("/employees")
    public Employee saveEmployee (@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // GET - / api / employees - Read a list of Employees
    // localhost:8082/api/employees
    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList() {
        return employeeService.fetchEmployeeList();
    }

    // GET - / api / employees / {employeeId} - Read a single employee by id
    // localhost:8082/api/employee/1
    @GetMapping("/employee/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException {
        return employeeService.fetchEmployeeById(employeeId);
    }


    // PUT - / api / employees / {employeeId} - Update an existing employee with the url (Postman Optional)
    // localhost:8082/api/employee/6?firstName=Linda&lastName=Turula&email=linda@gmail.com
    @PutMapping("/employee/{id}")
    public void updateEmployee(@PathVariable("id") Long employeeId,
                               @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String lastName,
                               @RequestParam(required = false) String email) {
        employeeService.updateEmployee(employeeId, firstName, lastName, email);
    }

    // PUT - / api / employees / {employeeId} - Update an existing employee with RequestBody (Postman mandatory)
    // localhost:8082/api/employee/6
    @PutMapping("/employeeV2/{id}")
    public Employee UpdateEmployeeV2(@PathVariable("id") Long employeeId,
                                      @RequestBody Employee employee) {
        return employeeService.UpdateEmployeeV2(employeeId, employee);
    }

    // DELETE - / api / employees / {employeeId} - Delete an existing employee
    // localhost:8082/api/employee/7
    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return "Employee deleted successfully.";
    }

    // GET - / api / employees / size - Return the number of employees
    // localhost:8082/api/employee/size
    @GetMapping("/employee/size")
    public String numberOfEmployees() {
        return employeeService.numberOfEmployees();
    }


}
