package org.training.employeemanagement.service;

import java.util.List;

import javax.validation.Valid;

import org.training.employeemanagement.dto.DepartmentCreate;
import org.training.employeemanagement.entity.Department;

public interface DepartmentService {

	Department updateDepartment(@Valid DepartmentCreate update, String deptName);

	Department addLocations(@Valid String deptName, List<String> locations);

	Department deleteLocations(@Valid String deptName, List<String> locations);

}
