package com.javaproject.javacollections;

import java.util.ArrayList;
import java.util.Iterator;

import com.javaproject.javaoopsconcept.Student;

public class ArrayListDriver {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings({ "rawtypes" })
		ArrayList al = new ArrayList<>();
		Student s1 = new Student("kartik", 11);
		Student s2 = new Student("Adam", 12);
		Student s3 = new Student("Kotappa", 13);
		Student s4 = new Student("Jayanth", 14);
		Student s5 = new Student("Girish", 15);
		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		al.add(s5);
		System.out.println(al);
		Iterator<Student> it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
