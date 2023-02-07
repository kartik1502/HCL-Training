package org.training.employeemanagement.repository;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.employeemanagement.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Department findDepartmentByDeptName(@NotNull(message = "Department Name is required") String deptName);

}
