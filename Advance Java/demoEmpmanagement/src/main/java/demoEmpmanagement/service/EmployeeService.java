package demoEmpmanagement.service;

import demoEmpmanagement.model.Employee;
import demoEmpmanagement.repository.EmployeeRepository;

public class EmployeeService {
	
	EmployeeRepository employeeRepository = new EmployeeRepository();
 public boolean  addEmployee(Employee employee)
 {
	boolean res= employeeRepository.addEmployee(employee);
	return res;
 }
}
