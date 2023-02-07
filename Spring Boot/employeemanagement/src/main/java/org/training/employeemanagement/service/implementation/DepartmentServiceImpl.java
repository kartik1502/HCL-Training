package org.training.employeemanagement.service.implementation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.employeemanagement.dto.DepartmentCreate;
import org.training.employeemanagement.entity.Department;
import org.training.employeemanagement.entity.Location;
import org.training.employeemanagement.exception.NoSuchDepartmentExists;
import org.training.employeemanagement.repository.DepartmentRepository;
import org.training.employeemanagement.repository.LocationRepository;
import org.training.employeemanagement.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	LocationRepository locationRepository;

	@Override
	public Department updateDepartment(@Valid DepartmentCreate update, String deptName) {

		Department department = departmentRepository.findDepartmentByDeptName(deptName);
		if (department == null) {
			throw new NoSuchDepartmentExists("Department with " + deptName + " dose not exists");
		}
		BeanUtils.copyProperties(update, department);
		List<Location> locations = department.getLocation();
		update.getLocation().forEach(e -> {
			Location location = locationRepository.findLocationByLocationName(e.getLocationName());
			if (location != null) {
				locations.add(location);
			} else {
				Location location1 = new Location();
				BeanUtils.copyProperties(e, location1);
				locationRepository.save(location1);
				locations.add(location1);
			}
		});
		department.setLocation(locations);
		return departmentRepository.save(department);
	}

	@Override
	public Department addLocations(@Valid String deptName, List<String> locations) {

		Department department = departmentRepository.findDepartmentByDeptName(deptName);
		if (department == null) {
			throw new NoSuchDepartmentExists("Department with " + deptName + " dose not exists");
		}
		List<Location> locations1 = department.getLocation();
		locations.forEach(e -> {
			Location location = locationRepository.findLocationByLocationName(e);
			locations1.add(location);
		});
		department.setLocation(locations1);
		return departmentRepository.save(department);
	}

	@Override
	public Department deleteLocations(@Valid String deptName, List<String> locations) {
		
		Department department = departmentRepository.findDepartmentByDeptName(deptName);
		if (department == null) {
			throw new NoSuchDepartmentExists("Department with " + deptName + " dose not exists");
		}
		List<Location> locations1 = department.getLocation();
		locations.forEach(e -> {
			Location location = locationRepository.findLocationByLocationName(e);
			locations1.remove(location);
		});
		department.setLocation(locations1);
		return departmentRepository.save(department);
	}

}
