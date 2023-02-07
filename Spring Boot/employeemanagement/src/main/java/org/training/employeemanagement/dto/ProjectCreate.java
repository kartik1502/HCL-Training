package org.training.employeemanagement.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class ProjectCreate {

	@NotNull(message = "Project name is required")
	@Pattern(regexp = "[a-zA-Z ]+", message = "Enter a valid project name")
	private String projectName;

	@NotNull(message = "Department Name is required")
	@Pattern(regexp = "[a-zA-Z ]+", message = "Enter a valid department Name")
	private String deptName;

	@Min(10)
	@Max(700)
	private int workHours;

	private List<String> employees;
}
