package org.hcltraining.studentmanagement.service;

import org.hcltraining.studentmanagement.entity.Student;
import org.hcltraining.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    public StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Student getById(int studentId) {
        return repository.findById(studentId).get();
    }

    public Student updateStudent(Student student, int studentId) {
        Student student1 = repository.findById((Integer) studentId).get();
        student1.setStudentName(student.getStudentName());
        student1.setStudentEmail(student.getStudentEmail());
        student1.setStudentContact(student.getStudentContact());
        return repository.save(student1);
    }

    public List<Student> getAllStudents() {
        return (List<Student>) repository.findAll();
    }

    public void deleteById(int studentId) {
        repository.deleteById(studentId);
    }

    @Override
    public Student findByStudentName(String studentName) {
        return repository.findStudentByStudentName(studentName);
    }

    @Override
    public void deleteByStudentName(String studentName) {
        repository.removeStudentByStudentName(studentName);
    }

    @Override
    public List<Student> findAllByStudentAge(int start, int end) {
        return repository.findAllByStudentAgeBetween(start, end);
    }

    @Override
    public List<Student> findStudentByStudentNameStartingWith(String studentName) {
        return repository.findStudentByStudentNameIsStartingWith(studentName);
    }

    @Override
    public List<Student> findAllStudentOrderByStudentName() {
        return repository.findStudentByOrderByStudentName();
    }

    @Override
    public List<Student> findStudentNameContains(String studentName) {
        return repository.findByStudentNameContains(studentName);
    }

    @Override
    public List<Student> getAllStudentPaginated(int pageNo, int pageSize) {
        Page<Student> studentPage = repository.findAll(PageRequest.of(pageNo,pageSize));
        return studentPage.toList();
    }

    @Override
    public List<Student> getAllStudentsAfter(String date) {
        return repository.findAllByAdmissionDateAfter(Date.valueOf(date));
    }

    @Override
    public List<Student> getAllStudentAgeGreaterThan(int age) {
        return repository.findStudentByStudentAgeGreaterThan(age);
    }

    @Override
    public List<Student> getAllStudentByStudentNameOrAge(String studentName, int age) {
        return repository.findByStudentNameOrStudentAge(studentName,age);
    }

    @Override
    public List<Student> getAllStudentAgeIn(List<Integer> ageList) {

        return repository.findStudentByStudentAgeIn(ageList);
    }

    @Override
    public List<Student> getStudentNameEnding(String studentName) {
        return repository.findStudentByStudentNameEndingWith(studentName);
    }

    @Override
    public List<Student> getStudenNameIgnoreCase(String studentName) {
        return repository.findByStudentNameIgnoreCase(studentName);
    }


}
