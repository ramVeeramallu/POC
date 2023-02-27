package com.example.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.employee.model.Employee;

// interface extending crud repository
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

//import com.ios.exception.EmployeeNotFoundExceptoin;
//import com.ios.exception.WrongInputException;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class EmployeeRepository {

    List<Employee> employeeData = new ArrayList<>();

    @PostConstruct
    public void employeeData() {

        employeeData.add(new Employee(1223, "Anoop", 32000D, 960353451L));
        employeeData.add(new Employee(1555, "Revanth", 33000D, 630020300L));
        employeeData.add(new Employee(1342, "Sai", 32000D, 852080036L));
        employeeData.add(new Employee(1674, "Abdul", 24000D, 799370673L));
        employeeData.add(new Employee(3027, "SaiRam", 30000D, 934610060L));
        employeeData.add(new Employee(1123, "Shankar", 29000D, 818492196L));

    }

    public List<Employee> getAllEmployees() {
        return employeeData;
    }

    public Employee saveEmployee(Employee employee) {
        if (employeeData.add(employee))
            return employee;
        else
            return null;
    }

    public boolean deleteEmployeeById(Integer employeeId)  {

        log.info("Searching....");
        Employee foundEmployee = findById(employeeId);
        log.info("Found Employee....{}",foundEmployee);
        employeeData.remove(foundEmployee);
        return true;
    }

    public Employee updateEmployee(Integer employeeId, Employee updatedEmployee)
            {

        Employee foundEmployee =findById(employeeId);

        foundEmployee.setName(updatedEmployee.getName());
        foundEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
        foundEmployee.setSalary(updatedEmployee.getSalary());

                Integer index = employeeData.indexOf(foundEmployee);
        employeeData.set(index, foundEmployee);
        return 	foundEmployee;
    }

    public List<Employee> findByName(String name){

        StringBuilder bld = new StringBuilder();

        if (name.length() >= 3) {
            for (int i = 0; i <= 2; ++i) {
                bld.append(name.charAt(i));
            }
        } else {
            log.info("INPUT NOT VALID :{}", name);
        }
        String str = bld.toString();

        List<Employee> employeeList = employeeData.stream().filter(emp -> emp.getName().startsWith(str))
                .collect(Collectors.toList());

        if (employeeList.isEmpty()) {
            log.info("Employee Not Found with name: {}", name);
        }
        return employeeList;
    }

    public Employee findById(Integer employeeId)  {
        Optional<Employee> emp =
                Optional.of(employeeData.stream().filter(employee -> employee.getEmployeeId() == employeeId).findFirst()
                        .orElseThrow(() -> new RuntimeException("Employee Not Found")));

        return emp.get();
    }

}
