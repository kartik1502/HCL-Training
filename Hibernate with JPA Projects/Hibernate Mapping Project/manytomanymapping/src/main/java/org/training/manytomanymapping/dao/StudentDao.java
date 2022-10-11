package org.training.manytomanymapping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.training.manytomanymapping.dto.Student;
import org.training.manytomanymapping.dto.Subject;

public class StudentDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveStudent(List<Student> student,List<Subject> subject){
		 entityTransaction.begin();
		 for (Student student2 : student) {
			for (Subject subject2 : subject) {
				entityManager.persist(subject2);
			}
			entityManager.persist(student2);
		}
		 entityTransaction.commit();
	}
	
	public Student getStudentSubjectDetails(int id){
		Student student = entityManager.find(Student.class, id);
		return student;
	}
	
	public void updateStudentSubject(int id){
		
	}
	public void deleteStudentSubjectDetails(int id){
		entityTransaction.begin();
		Student student = entityManager.find(Student.class, id);
		for (Subject subject : student.getSubject()) {
			entityManager.remove(subject);
		}
		entityManager.remove(student);
		entityTransaction.commit();
	}
}
