package com.javaproject.javaoopsconcept;

public class School {
	
	private String principalName;
	private int noOfStaffs;
	private String schoolName;
	
	public School() {}
	public School(String principalName, String schoolName) {
		this.principalName = principalName;
		this.schoolName = schoolName;
	}
	public School(String principalName,int noOfStaffs, String schoolName) {
		this(principalName,schoolName);
		this.noOfStaffs = noOfStaffs;
	}
	
	public int getNoOfStaffs() {
		return noOfStaffs;
	}
	public void setNoOfStaffs(int noOfStaffs) {
		this.noOfStaffs = noOfStaffs;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	
}
