package org.training.employeemanagement.service;

import java.util.List;

import javax.validation.Valid;

import org.training.employeemanagement.dto.ProjectCreate;
import org.training.employeemanagement.entity.Project;

public interface ProjectService {

	Project addProject(@Valid ProjectCreate create);

	Project updatePeoject(@Valid ProjectCreate project, String projectName);

	List<Project> getProjectDetails();

	Project delete(@Valid String projectName);

	Project addEmployees(@Valid List<String> employees, @Valid String projectName);

	Project deleteEmployees(@Valid String projectName, List<String> employees);

}
