//package com.example.employee;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import com.example.employee.model.Employee;
//import com.example.employee.repository.EmployeeRepository;
//import com.example.employee.service.EmployeeService;
//
//@SpringBootTest
//public class EmployeeApplicationTests
//{
//
//  EmployeeService employeeService = Mockito.mock(EmployeeService.class);
//  EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
//	@Test
// void testSaveEmployee()
//{
//	Employee employee = new Employee();
// employee.setEmployeeId(3456);
// employee.setName("Satish");
// employee.setPhoneNumber(960382102);
// employee.setSalary(22000);
// Mockito.when(employeeRepository.saveEmployee(employee)).thenReturn(employee);
// assertThat(employeeService.addEmployee(employee)).isEqualTo(employee);
//  }
//	@Test
//  void testGetAllEmployee() {
//     List<Employee> employeeData = new ArrayList<>();
//     employeeData.add(new Employee(1223, "Anoop", 32000, 960353451));
//     employeeData.add(new Employee(1555, "Revanth", 33000, 630020300));
//     employeeData.add(new Employee(1342, "Sai", 32000, 852080036));
//     Mockito.when(employeeRepository.getAllEmployees()).thenReturn(employeeData);
//     assertThat(employeeService.getAllEmployees()).isEqualTo(employeeData);
//    }
// @Test
//void testDeleteEmployeeById()
//	{
//		Employee employee = new Employee();
//
//       employee.setEmployeeId(3456);
//       employee.setName("Satish");
//       employee.setPhoneNumber(960382102);
//       employee.setSalary(22000);
//       Mockito.when(employeeRepository.findById(3456)).thenReturn(employee);
//       Mockito.when(employeeRepository.deleteEmployeeById(employee.getEmployeeId())).thenReturn(false);
//       assertFalse(employeeRepository.deleteEmployeeById(employee.getEmployeeId()));
// }
// @Test
// void testUpdateEmployee()
//{
// Employee employee = new Employee();
// employee.setEmployeeId(3456);
// employee.setName("Satish");
// employee.setPhoneNumber(960382102);
// employee.setSalary(22000);
// Mockito.when(employeeRepository.findById(3456)).thenReturn(employee);
// employee.setName("Rishi");
// employee.setPhoneNumber(998877665);
// Mockito.when(employeeRepository.updateEmployee(3456, employee)).thenReturn(employee);
// assertThat(employeeService.updateEmployee(employee,3456)).isEqualTo(employee);
// }
// @Test
// void testFindByName()
//{
// List<Employee> employeeList = new ArrayList<>();
// employeeList.add(new Employee(1342, "Sai", 32000, 852080036));
// employeeList.add(new Employee(3027, "SaiRam", 30000, 934610060));
// Mockito.when(employeeRepository.findByName("Sai")).thenReturn(employeeList);
// assertThat(employeeService.findByName("Sai")).isEqualTo(employeeList);
// }
// @Test
//void testFindById()
// {
// Employee employee = new Employee();
// employee.setEmployeeId(3456);
// employee.setName("Satish");
// employee.setPhoneNumber(960382102);
// employee.setSalary(22000);
// Mockito.when(employeeRepository.findById(3456)).thenReturn(employee);
// assertThat(employeeService.findById(3456)).isEqualTo(employee);
//	}
//}
