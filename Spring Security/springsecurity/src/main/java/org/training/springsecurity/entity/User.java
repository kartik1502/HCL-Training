package org.training.springsecurity.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "BINARY(36)")
	private UUID userId;

	private String userName;

	private String userEmailId;

	private String userPassword;

	private Role role;

}
