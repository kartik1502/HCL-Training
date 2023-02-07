package org.training.employeemanagement.service;

import java.util.List;

import javax.validation.Valid;

import org.training.employeemanagement.dto.EmployeeCreate;
import org.training.employeemanagement.dto.EmployeeUpdate;
import org.training.employeemanagement.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(EmployeeCreate employee);

	List<Employee> getAllEmployees();

	Employee deleteEmployee(@Valid String empEmail);

	Employee updateEmployee(@Valid EmployeeUpdate update, String empEmail);

}
