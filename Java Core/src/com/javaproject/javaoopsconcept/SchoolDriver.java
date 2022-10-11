package com.javaproject.javaoopsconcept;

public class SchoolDriver {

	public static void main(String[] args) {
		
		School s = new School("Arya Vikram",25,"Arya Institute");
		System.out.println(s.getPrincipalName());
		System.out.println(s.getNoOfStaffs());
		System.out.println(s.getSchoolName());
		s.setNoOfStaffs(30);
		System.out.println(s.getNoOfStaffs());

	}

}
