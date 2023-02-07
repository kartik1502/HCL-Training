package org.training.employeemanagement.service.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.employeemanagement.dto.EmployeeCreate;
import org.training.employeemanagement.dto.EmployeeUpdate;
import org.training.employeemanagement.entity.Department;
import org.training.employeemanagement.entity.Employee;
import org.training.employeemanagement.entity.Location;
import org.training.employeemanagement.exception.EmployeeAlreadyExists;
import org.training.employeemanagement.exception.NoSuchDepartmentExists;
import org.training.employeemanagement.exception.NoSuchEmployeeExists;
import org.training.employeemanagement.repository.DepartmentRepository;
import org.training.employeemanagement.repository.EmployeeRepository;
import org.training.employeemanagement.repository.LocationRepository;
import org.training.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	LocationRepository locationRepository;

	@Override
	public Employee saveEmployee(@Valid EmployeeCreate employeeCreate) {

		if (repository.findEmployeeByEmpEmail(employeeCreate.getEmpEmail()) != null) {
			throw new EmployeeAlreadyExists(
					"Employee with email Id: " + employeeCreate.getEmpEmail() + " already exists");
		}

		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeCreate, employee);

		Department department1 = departmentRepository
				.findDepartmentByDeptName(employeeCreate.getDepartment().getDeptName());
		if (department1 == null) {
			Department department = new Department();
			BeanUtils.copyProperties(employeeCreate.getDepartment(), department);
			employee.setDepartment(department);
			List<Location> locations = new ArrayList<>();
			employeeCreate.getDepartment().getLocation().forEach(e -> {
				Location location = new Location();
				Location location1 = locationRepository.findLocationByLocationName(e.getLocationName());
				if (location1 == null) {
					BeanUtils.copyProperties(e, location);
				} else {
					BeanUtils.copyProperties(location1, location);
				}
				locations.add(location);
			});
			employee.getDepartment().setLocation(locations);
		} else {
			employee.setDepartment(department1);
			employee.getDepartment().setLocation(department1.getLocation());
		}
		return repository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee deleteEmployee(@Valid String empEmail) {

		Employee employee = repository.findEmployeeByEmpEmail(empEmail);
		if (employee == null) {
			throw new NoSuchEmployeeExists("Employee with email Id: " + empEmail + " dose not Exists");
		}
		int count = repository.getNoOfEmployees(employee.getDepartment().getDepartmentId());
		repository.delete(employee);
		if(count == 1) {
			departmentRepository.delete(employee.getDepartment());
		}
		return employee;
	}

	@Override
	public Employee updateEmployee(@Valid EmployeeUpdate update, String empEmail) {

		Employee employee = repository.findEmployeeByEmpEmail(empEmail);
		if (employee == null) {
			throw new NoSuchEmployeeExists("Employee with email Id: " + empEmail + " dose not Exists");
		}

		BeanUtils.copyProperties(update, employee);
		Department department = departmentRepository.findDepartmentByDeptName(update.getDeptName());
		if (department == null) {
			throw new NoSuchDepartmentExists("Deapartment " + update.getDeptName() + " dose not exists");
		}
		employee.setDepartment(department);
		return repository.save(employee);
	}

}
