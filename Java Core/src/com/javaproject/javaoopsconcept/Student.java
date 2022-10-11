package com.javaproject.javaoopsconcept;

public class Student {
	String name;
	int studId;
	public Student(String name, int studId) {
		super();
		this.name = name;
		this.studId = studId;
	}
	@Override
	public String toString() {
		return "Student name: " + name + " ,Student Id: " + studId;
	}
	public int compareTo(Object o){
		Student st = (Student)o;
		return this.studId - st.studId;
	}
}