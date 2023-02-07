package org.training.employeemanagement.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class DepartmentCreate {

	@NotNull(message = "Department Name is required")
	@Pattern(regexp = "[a-zA-Z ]+", message = "Enter a valid department Name")
	private String deptName;

	
	private List<LocationCreate> location;
}
