package org.training.employeemanagement.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;

	@NotNull(message = "Project name is required")
	@Pattern(regexp = "[a-zA-Z ]+", message = "Enter a valid project name")
	private String projectName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
	private Department department;
	
	@Min(10)
	@Max(700)
	private int workHours;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Employee> employees;

}
