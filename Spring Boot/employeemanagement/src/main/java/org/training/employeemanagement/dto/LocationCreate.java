package org.training.employeemanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class LocationCreate {

	@NotNull(message = "Location Name is required")
	@Pattern(regexp = "[a-zA-Z0-9 ]+", message = "Enter a valid Location")
	private String locationName;
}
