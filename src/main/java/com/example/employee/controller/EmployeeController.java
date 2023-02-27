package com.example.employee.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
public class EmployeeController {

    static final Logger logger  = LogManager.getLogger(EmployeeController.class.getName());

    @Autowired
    private EmployeeService employeeService;

    // displaying list of all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    // displaying employee by id
    @GetMapping("/employees/id/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.findById(id);
    }

    // displaying employee by id
    @GetMapping("/employees/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name){
        return employeeService.findByName(name);
    }

    // inserting employee
    @PostMapping("/employees")
    public void addEmployees(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    //updating employee by id
    @PutMapping("/employees/{id}")
    public void updateEmployee(@RequestBody Employee e, @PathVariable Integer id){
        employeeService.updateEmployee(e, id);
    }

    // deleting employee by id
    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeByID(@PathVariable Integer id){
        employeeService.deleteEmployeeByID(id);
    }

    // updating/ patching employee by id
    @PatchMapping("/employees/{id}")
    public void patchEmployeeByID(@RequestBody Employee e, @PathVariable Integer id) {
        employeeService.updateEmployee(e, id);
    }
}