package org.hcltraining.studentmanagement.service;

import org.hcltraining.studentmanagement.dto.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    Student getById(int studentId);

    Student updateStudent(Student student,int studentId);

    List<Student> getAllStudents();

    void deleteById(int studentId);

}
