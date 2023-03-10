package org.training.springsecurity.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	@NonNull
	@Pattern(regexp = "[a-zA-Z ]+", message = "Invalid User Id")
	private String userName;
	
	@NotNull
	@Email(message = "Invalid Email Id")
	private String userEmailId;
	
	@NotNull
	@Pattern(regexp = "^[(a-z)(A-Z)(0-9)(@#$%&*!)]{8,}", message = "Invalid password pattern")
	private String password;
	
	@NotNull
	@Pattern(regexp = "^[(a-z)(A-Z)(0-9)(@#$%&*!)]{8,}", message = "Invalid password pattern")
	private String repeatPassword;
	
	private String role;

	public UserDto(@NonNull @Pattern(regexp = "[a-zA-Z ]+", message = "Invalid User Id") String userName,
			@NotNull @Email(message = "Invalid Email Id") String userEmailId, String role) {
		super();
		this.userName = userName;
		this.userEmailId = userEmailId;
		this.role = role;
	}
	
	
	
	

}
