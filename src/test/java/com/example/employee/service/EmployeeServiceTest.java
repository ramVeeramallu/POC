package com.example.employee.service;


import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    EmployeeService employeeService = Mockito.mock(EmployeeService.class);
    EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);

    @Test
    void testGetAllEmployee() {
        List<Employee> employeeData = employeeRepository.getAllEmployees();
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeData);
        assertNotNull(employeeData);
        assertThat(employeeService.getAllEmployees()).isEqualTo(employeeData);
    }
    @Test
    void testDeleteEmployeeById()
    {
        Employee employee = new Employee();
        employee.setEmployeeId(3456);
        employee.setName("Satish");
        employee.setPhoneNumber(960382102L);
        employee.setSalary(22000D);
        Mockito.when(employeeRepository.findById(3456)).thenReturn(employee);
        Mockito.when(employeeRepository.deleteEmployeeById(employee.getEmployeeId())).thenReturn(false);
        assertFalse(employeeRepository.deleteEmployeeById(employee.getEmployeeId()));
    }
    @Test
    void testUpdateEmployee()
    {
        List<Employee> employeeData = employeeRepository.getAllEmployees();
        for(Employee emp: employeeData) {
            Employee emp1 = employeeRepository.findById(3456);
            Employee employee = new Employee();
            employee.setName("Satish");
            Employee updatedEmployee = employeeRepository.saveEmployee(employee);
            Mockito.when(employeeService.updateEmployee( employee,3456)).thenReturn(employee);
            assertThat(updatedEmployee.getName()).isEqualTo("Satish");
        }
    }
    @Test
    void testFindByName()
    {
        List<Employee> employeeList = employeeRepository.findByName("Sai");
        Mockito.when(employeeService.findByName("Sai")).thenReturn(employeeList);
        assertThat(employeeService.findByName("Sai")).isEqualTo(employeeList);
    }
    @Test
    void testFindById()
    {
        Employee employee = employeeRepository.findById(3456);
        Mockito.when(employeeService.findById(3456)).thenReturn(employee);
        assertThat(employeeService.findById(3456)).isEqualTo(employee);
    }
}