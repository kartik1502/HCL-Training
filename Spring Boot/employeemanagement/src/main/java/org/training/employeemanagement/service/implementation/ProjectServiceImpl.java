package org.training.employeemanagement.service.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.employeemanagement.dto.ProjectCreate;
import org.training.employeemanagement.entity.Department;
import org.training.employeemanagement.entity.Employee;
import org.training.employeemanagement.entity.Project;
import org.training.employeemanagement.exception.NoSuchDepartmentExists;
import org.training.employeemanagement.exception.NoSuchEmployeeExists;
import org.training.employeemanagement.exception.NoSuchProjectExists;
import org.training.employeemanagement.repository.DepartmentRepository;
import org.training.employeemanagement.repository.EmployeeRepository;
import org.training.employeemanagement.repository.ProjectRepository;
import org.training.employeemanagement.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Project addProject(@Valid ProjectCreate create) {
		
		Department department = departmentRepository.findDepartmentByDeptName(create.getDeptName());
		if (department == null) {
			throw new NoSuchDepartmentExists("Department " + create.getDeptName() + " dose not exists");
		}
		List<Employee> employees = new ArrayList<>();
		create.getEmployees().forEach(e -> {
			Employee employee = employeeRepository.findEmployeeByEmpEmail(e);
			if (employee == null) {
				throw new NoSuchEmployeeExists("Employee with email Id: " + e + " dose not exists");
			}
			if(department.getDepartmentId() != employee.getDepartment().getDepartmentId()) {
				throw new NoSuchEmployeeExists("Employee with email Id: "+employee.getEmpEmail()+" dose not belong to the "+department.getDeptName()+" department");
			}
			employees.add(employee);
		});
		Project project1 = new Project();
		Project project = projectRepository.findProjectByProjectName(create.getProjectName());
		if(project == null) {
			BeanUtils.copyProperties(create, project1);
			project1.setDepartment(department);
			project1.setEmployees(employees);
		}
		else {
			BeanUtils.copyProperties(project, project1);
			project1.setDepartment(department);
			project1.setEmployees(employees);
		}
		
		return projectRepository.save(project1);
	}

	@Override
	public Project updatePeoject(@Valid ProjectCreate project, String projectName) {
		
		Project project2 = projectRepository.findProjectByProjectName(projectName);
		if(project2 == null) {
			throw new NoSuchProjectExists("Project "+projectName+" dose not exists");
		}
		
		Department department = departmentRepository.findDepartmentByDeptName(project.getDeptName());
		if(department == null) {
			throw new NoSuchDepartmentExists("Department "+project.getDeptName()+" dose not exists");
		}
		List<Employee> employees = new ArrayList<>();
		project.getEmployees().forEach(e -> {
			Employee employee = employeeRepository.findEmployeeByEmpEmail(e);
			if(employee == null) {
				throw new NoSuchEmployeeExists("Employee with email Id: "+e+" dose not exists");
			}
			if(department.getDepartmentId() != employee.getDepartment().getDepartmentId()) {
				throw new NoSuchEmployeeExists("Employee with email Id: "+employee.getEmpEmail()+" dose not belong to the "+department.getDeptName()+" department");
			}
			employees.add(employee);
		});
		BeanUtils.copyProperties(project, project2);
		project2.setDepartment(department);
		project2.setEmployees(employees);
		return projectRepository.save(project2);
	}

	@Override
	public List<Project> getProjectDetails() {
		return projectRepository.findAll();
	}

	@Override
	public Project delete(@Valid String projectName) {
		
		Project project = projectRepository.findProjectByProjectName(projectName);
		if(project == null) {
			throw new NoSuchProjectExists("Project "+projectName+" dose not exists");
		}
		projectRepository.delete(project);
		return project;
	}

	@Override
	public Project addEmployees(@Valid List<String> employees, String projectName) {
		
		Project project = projectRepository.findProjectByProjectName(projectName);
		if(project == null) {
			throw new NoSuchProjectExists("Project "+projectName+" dose not exists");
		}
		List<Employee> employees1 = project.getEmployees();
		employees.forEach(e -> {
			Employee employee = employeeRepository.findEmployeeByEmpEmail(e);
			if(employee == null) {
				throw new NoSuchEmployeeExists("Employee with email Id: "+e+" dose not exists");
			}
			if(employee.getDepartment().getDepartmentId() != project.getDepartment().getDepartmentId()) {
				throw new NoSuchEmployeeExists("Employee with email Id: "+employee.getEmpEmail()+" dose not belong to the "+project.getDepartment().getDeptName()+" department");
			}
			employees1.add(employee);
		});
		project.setEmployees(employees1);
		return projectRepository.save(project);
	}

	@Override
	public Project deleteEmployees(@Valid String projectName, List<String> employees) {
		
		Project project = projectRepository.findProjectByProjectName(projectName);
		if(project == null) {
			throw new NoSuchProjectExists("Project "+projectName+" dose not exists");
		}
		List<Employee> employees2 = project.getEmployees();
		employees.forEach(e -> {
			Employee employee = employeeRepository.findEmployeeByEmpEmail(e);
			employees2.remove(employee);
		});
		project.setEmployees(employees2);
		return projectRepository.save(project);
	}
	
	

}
