package org.training.studentmanagement.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.studentmanagement.entity.Student;
import org.training.studentmanagement.repository.StudentRepository;
import org.training.studentmanagement.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    public StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

}
