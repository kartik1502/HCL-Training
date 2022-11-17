package org.hcltraining.studentmanagement.service;

import org.hcltraining.studentmanagement.dto.Student;
import org.hcltraining.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
    public StudentRepository repository;
    
    public Student saveStudent(Student student){
        return repository.save(student);
    }

    public Student getById(int studentId){
        return repository.findById(studentId).get();
    }

    public Student updateStudent(Student student,int studentId){
        Student student1 = repository.findById((Integer) studentId).get();
        student1.setStudentName(student.getStudentName());
        student1.setStudentEmail(student.getStudentEmail());
        student1.setStudentContact(student.getStudentContact());
        return repository.save(student1);
    }

    public List<Student> getAllStudents(){
        return (List<Student>) repository.findAll();
    }

    public void deleteById(int studentId){
        repository.deleteById(studentId);
    }

}
