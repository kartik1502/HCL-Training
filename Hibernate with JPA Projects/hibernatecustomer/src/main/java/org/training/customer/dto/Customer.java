package org.training.customer.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custId")
	private int id;
	@Column(name = "custName")
	private String name;
	@Override
	public String toString() {
		return "Customer Id: " + getId() + "\nCustomer Name: " + getName() + "\nCustomer Email Id: " + getEmailId()
				+ "\nCustomer Phone No:" + getPhoneNo() + "\n-----------------------------------------------------------------\n";
	}

	@Column(name = "custEmailId")
	private String emailId;
	@Column(name = "custPhoneNo")
	private long phoneNo;

	public Customer() {
		super();
	}

	public Customer(int id) {
		super();
		this.id = id;
	}

	public Customer(int id, String name, String emailId, long phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

}
