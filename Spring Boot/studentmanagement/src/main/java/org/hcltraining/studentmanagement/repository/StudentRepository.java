package org.hcltraining.studentmanagement.repository;

import org.hcltraining.studentmanagement.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentByStudentName(String studentName);

    void removeStudentByStudentName(String studentName);

    List<Student> findAllByStudentAgeBetween(int start, int end);

    List<Student> findStudentByStudentNameIsStartingWith(String studentName);

    @Query("select s from Student s where s.studentName like :studentName%")
    List<Student> findByStudentNameContaining(String studentName);

    @Query("select s from Student s order by s.studentName")
    List<Student> findAllStudentOrderByStudentName();

}
