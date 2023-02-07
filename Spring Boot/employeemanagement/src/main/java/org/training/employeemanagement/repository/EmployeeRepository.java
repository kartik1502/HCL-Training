package org.training.employeemanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.training.employeemanagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findEmployeeByEmpEmail(String empEmail);

	@Query("select count(e) from Employee e where department.departmentId = ?1")
	int getNoOfEmployees(int deptNo);
}
