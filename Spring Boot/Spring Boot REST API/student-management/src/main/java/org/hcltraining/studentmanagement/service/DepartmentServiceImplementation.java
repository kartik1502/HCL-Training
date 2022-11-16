package org.hcltraining.studentmanagement.service;

import java.util.List;
import java.util.Objects;

import org.hcltraining.studentmanagement.dto.Department;
import org.hcltraining.studentmanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImplementation implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;


	// Read operation
	@Override
	public List<Department> fetchDepartmentList() {
		return (List<Department>) departmentRepository.findAll();
	}

	// Delete operation
	@Override
	public void deleteDepartmentById(int departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department updateDepartment(Department department, int departmentId) {
		Department depDB
        = departmentRepository.findById(departmentId)
              .get();

    if (Objects.nonNull(department.getDepartmentName())
        && !"".equalsIgnoreCase(
            department.getDepartmentName())) {
        depDB.setDepartmentName(
            department.getDepartmentName());
    }

    if (Objects.nonNull(
            department.getDepartmentAddress())
        && !"".equalsIgnoreCase(
            department.getDepartmentAddress())) {
        depDB.setDepartmentAddress(
            department.getDepartmentAddress());
    }

    if (Objects.nonNull(department.getDepartmentCode())
        && !"".equalsIgnoreCase(
            department.getDepartmentCode())) {
        depDB.setDepartmentCode(
            department.getDepartmentCode());
    }

    return departmentRepository.save(depDB);
	}

}
