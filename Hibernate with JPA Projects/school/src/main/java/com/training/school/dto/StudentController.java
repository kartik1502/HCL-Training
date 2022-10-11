package com.training.school.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentController {

	public void saveStudent(Student student){
	
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student stud = new Student();
		stud.setStudId(student.getStudId());
		stud.setStudName(student.getStudName());
		stud.setStudEmailId(student.getStudEmailId());
		stud.setStudPhoneNo(student.getStudPhoneNo());
		entityTransaction.begin();
		entityManager.persist(stud);
		entityTransaction.commit();
	
	}
	
	public void updateStudent(Student student){
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student stud = entityManager.find(Student.class, student.getStudId());
		stud.setStudName(student.getStudName());
		stud.setStudEmailId(student.getStudEmailId());
		stud.setStudPhoneNo(stud.getStudPhoneNo());
		entityTransaction.begin();
		entityManager.persist(stud);
		entityTransaction.commit();
		
	}
	
	public void deleteById(Student student){
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student stud = entityManager.find(Student.class, student.getStudId());
		entityTransaction.begin();
		entityManager.remove(stud);
		entityTransaction.commit();
		
	}
	
	public List<Student> displayStudentDetails(){
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Student> sl = new ArrayList<>();
		Query query = entityManager.createQuery("select s from Student s");
		sl = query.getResultList();
		return sl;
	}
	
}
