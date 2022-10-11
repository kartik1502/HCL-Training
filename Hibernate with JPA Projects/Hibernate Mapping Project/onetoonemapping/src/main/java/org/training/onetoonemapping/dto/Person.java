package org.training.onetoonemapping.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String emailId;
	@OneToOne
	private Aadhar aadhar;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person Id:" + getId() + "\nPerson Name: " + getName() + "\nPerson Email Id: " + getEmailId()
				+ "\nAadhar Number: " + getAadhar().getAadharNumber()+ "\nAadhar Address: "+getAadhar().getAddress()+"\n";
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Aadhar getAadhar() {
		return aadhar;
	}

	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}

}
