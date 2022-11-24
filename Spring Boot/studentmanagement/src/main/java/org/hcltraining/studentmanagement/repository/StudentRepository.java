package org.hcltraining.studentmanagement.repository;

import org.hcltraining.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentByStudentName(String studentName);

    void removeStudentByStudentName(String studentName);

    List<Student> findAllByStudentAgeBetween(int start, int end);

    List<Student> findStudentByStudentNameIsStartingWith(String studentName);

    List<Student> findByStudentNameContains(String studentName);

    List<Student> findStudentByOrderByStudentName();

    List<Student> findByStudentNameOrStudentAge(String name,int age);

    List<Student> findAllByAdmissionDateAfter(Date date);
    
    List<Student> findStudentByAdmissionDateBetween(Date startDate,Date endDate);

    List<Student> findStudentByStudentAgeGreaterThan(int age);

    List<Student> findStudentByStudentAgeIn(List<Integer> age);

    List<Student> findStudentByStudentNameEndingWith(String studentName);

    List<Student> findByStudentNameIgnoreCase(String studentName);

    @Query("select sum(studentAge) from Student")
    int totalAge();
    
    List<Student> findByStudentNameNotNull();

    @Query("select count(studentAge) from Student where studentAge =:age")
	int getStudentAgeCount(int age);

    @Query("select avg(studentAge) from Student")
	int getAverageStudentAge();

    @Query("select max(studentAge) from Student")
	int getOldestStudent();
    
    @Query("select min(studentAge) from Student")
    int getYoungestStudent();

//	List<Student> findStudentByOrderByStudentAgeAscAndStudentIdAsc();
}
