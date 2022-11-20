package org.hcltraining.studentmanagement.service;

import org.hcltraining.studentmanagement.dto.Student;
import org.hcltraining.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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
        return repository.findAllStudentOrderByStudentName();
    }

    @Override
    public List<Student> findStudentNameLike(String studentName) {
        return repository.findByStudentNameContaining(studentName);
    }


}
