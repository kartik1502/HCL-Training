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
import org.training.employeemanagement.dto.ProjectCreate;
import org.training.employeemanagement.entity.Project;
import org.training.employeemanagement.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService service;

	@PostMapping("/")
	public ResponseEntity<Project> addProject(@Valid @RequestBody ProjectCreate create) {
		return new ResponseEntity<>(service.addProject(create), HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<Project> updateProject(@Valid @RequestBody ProjectCreate project,
			@RequestParam String projectName) {
		return new ResponseEntity<>(service.updatePeoject(project, projectName), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Project>> getProjectDetails() {
		return new ResponseEntity<>(service.getProjectDetails(), HttpStatus.OK);
	}

	@DeleteMapping("/")
	public ResponseEntity<Project> deleteProject(@Valid @RequestParam String projectName) {
		return new ResponseEntity<>(service.delete(projectName), HttpStatus.OK);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Project> addEmployees(@Valid @RequestParam String projectName, @RequestParam List<String> employees){
		return new ResponseEntity<>(service.addEmployees(employees, projectName), HttpStatus.OK);
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<Project> deleteEmployees(@Valid @RequestParam String projectName, @RequestParam List<String> employees){
		return new ResponseEntity<>(service.deleteEmployees(projectName, employees), HttpStatus.OK);
	}
}
