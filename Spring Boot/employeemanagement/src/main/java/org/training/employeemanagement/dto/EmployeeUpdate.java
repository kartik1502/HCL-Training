package org.training.employeemanagement.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EmployeeUpdate {

	@NotNull(message = "Name is required")
	@Pattern(regexp = "[a-zA-Z ]+", message = "Please Enter a valid name")
	private String empName;

	@NotNull(message = "Email is requred")
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Enter a valid Email Id")
	private String empEmail;

	@Min(23)
	@Max(62)
	private int empAge;

	@NotNull(message = "Contact Number is required")
	@Pattern(regexp = "[6789][0-9]{9}", message = "Enter the valid Contact Number")
	private String empContactNo;

	@Min(10000)
	@Max(600000)
	private int salary;

	@NotNull(message = "Department Name is required")
	@Pattern(regexp = "[a-zA-Z ]+", message = "Enter a valid department Name")
	private String deptName;
}
