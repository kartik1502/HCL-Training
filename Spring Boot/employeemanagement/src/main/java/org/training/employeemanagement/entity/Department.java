package org.training.employeemanagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentId;

	@NotNull(message = "Department Name is required")
	@Pattern(regexp = "[a-zA-Z ]+", message = "Enter a valid department Name")
	private String deptName;

	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Location> location;

}
