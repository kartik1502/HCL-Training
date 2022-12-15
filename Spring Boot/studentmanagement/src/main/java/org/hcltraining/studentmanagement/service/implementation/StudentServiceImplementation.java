package org.hcltraining.studentmanagement.service.implementation;

import org.hcltraining.studentmanagement.entity.Student;
import org.hcltraining.studentmanagement.repository.StudentRepository;
import org.hcltraining.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    public StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

}
