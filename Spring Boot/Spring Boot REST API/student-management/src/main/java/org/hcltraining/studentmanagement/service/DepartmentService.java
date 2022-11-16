package org.hcltraining.studentmanagement.service;

import java.util.List;

import org.hcltraining.studentmanagement.dto.Department;


public interface DepartmentService {

	Department saveDepartment(Department department);
	 
    // Read operation
    List<Department> fetchDepartmentList();
 
    // Update operation
    Department updateDepartment(Department department,
                                int departmentId);
 
    // Delete operation
    void deleteDepartmentById(int departmentId);
}
