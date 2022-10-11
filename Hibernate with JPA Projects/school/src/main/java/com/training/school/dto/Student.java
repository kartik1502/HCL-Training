package com.training.school.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int studId;
	private String studName;
	public Student() {
		super();
	}
	private String studEmailId;
	private long studPhoneNo;
	
	public Student(int studId) {
		super();
		this.studId = studId;
	}
	public Student(int studId, String studName, String studEmailId, long studPhoneNo) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studEmailId = studEmailId;
		this.studPhoneNo = studPhoneNo;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudEmailId() {
		return studEmailId;
	}
	public void setStudEmailId(String studEmailId) {
		this.studEmailId = studEmailId;
	}
	public long getStudPhoneNo() {
		return studPhoneNo;
	}
	public void setStudPhoneNo(long studPhoneNo) {
		this.studPhoneNo = studPhoneNo;
	}
	@Override
	public String toString() {
		return "Student Id: " + getStudId() + "\nStudent Name: " + getStudName() + "\nStudent Email Id:"
				+ getStudEmailId() + "\nStudent Phone Number:" + getStudPhoneNo()+"\n";
	}
	
	
}
