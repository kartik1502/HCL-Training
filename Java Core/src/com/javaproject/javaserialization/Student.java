package com.javaproject.javaserialization;

import java.io.Serializable;

public class Student implements Serializable {
	
	int studId;
	String name;
	long phoneNo;
	
	public Student() {}

	public Student(int studId, String name, long phoneNo) {super();
		this.studId = studId;
		this.name = name;
		this.phoneNo = phoneNo;
	}
}
