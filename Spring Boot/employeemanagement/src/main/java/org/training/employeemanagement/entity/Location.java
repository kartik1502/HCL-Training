package org.training.employeemanagement.entity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Location { 	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locationId;
	
	@NotNull(message = "Location Name is required")
	@Pattern(regexp = "[a-zA-Z0-9 ]+" ,message = "Enter a valid Location")
	private String locationName;
	
	
	
	
}
