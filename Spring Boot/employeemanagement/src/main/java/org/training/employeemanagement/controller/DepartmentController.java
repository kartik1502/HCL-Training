package org.training.employeemanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.employeemanagement.dto.DepartmentCreate;
import org.training.employeemanagement.entity.Department;
import org.training.employeemanagement.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService service;
	
	@PutMapping("/")
	public ResponseEntity<Department> updateDepartment(@Valid @RequestBody DepartmentCreate update, @RequestParam String deptName){
		return new ResponseEntity<>(service.updateDepartment(update, deptName), HttpStatus.OK);
	}
	
	@PutMapping("/locations")
	public ResponseEntity<Department> addLocations(@Valid @RequestParam String deptName, @RequestParam List<String> locations){
		return new ResponseEntity<>(service.addLocations(deptName, locations), HttpStatus.OK);
	}
	
	@DeleteMapping("/locations")
	public ResponseEntity<Department> deleteLocations(@Valid @RequestParam String deptName, @RequestParam List<String> locations){
		return new ResponseEntity<>(service.deleteLocations(deptName, locations), HttpStatus.OK);
	}
}
