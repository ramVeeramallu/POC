package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

// employee service class
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // fetching all employees
    public List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployees();
    }

    public Employee findById(Integer employeeId) {

        return employeeRepository.findById(employeeId);
    }

    public List<Employee> findByName(String name)  {
        return employeeRepository.findByName(name);
    }

    // inserting employee
    public Employee addEmployee(Employee e) {
        return employeeRepository.saveEmployee(e);
    }

    // updating employee by id
    public Employee updateEmployee(Employee emp, Integer id){
        return employeeRepository.updateEmployee(id, emp);
    }

//     deleting employee by id
    public void deleteEmployeeByID(Integer id){
        employeeRepository.deleteEmployeeById(id);
    }
}