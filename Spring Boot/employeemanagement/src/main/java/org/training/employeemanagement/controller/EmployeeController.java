package org.training.employeemanagement.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.employeemanagement.dto.EmployeeCreate;
import org.training.employeemanagement.dto.EmployeeUpdate;
import org.training.employeemanagement.entity.Employee;
import org.training.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeCreate employee){
		return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<Employee> deleteEmployee(@Valid @RequestParam String empEmail){
		return new ResponseEntity<>(service.deleteEmployee(empEmail), HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody EmployeeUpdate update,@RequestParam String empEmail){
		return new ResponseEntity<>(service.updateEmployee(update, empEmail), HttpStatus.OK);
	}
	

}
