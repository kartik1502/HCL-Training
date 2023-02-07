package org.training.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.employeemanagement.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

	Project findProjectByProjectName(String projectName);

}
