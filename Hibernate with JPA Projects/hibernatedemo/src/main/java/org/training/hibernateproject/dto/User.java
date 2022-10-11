package org.training.hibernateproject.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private int id;
	private String name;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "User Id: "+getId()+"\nUser Name: "+getName()+"\nUser Email Id: "+getEmail()+"\n-----------------------------------------------------------";
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
