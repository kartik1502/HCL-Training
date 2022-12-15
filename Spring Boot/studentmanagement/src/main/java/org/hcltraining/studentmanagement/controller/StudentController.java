package org.hcltraining.studentmanagement.controller;

import javax.validation.Valid;
import org.hcltraining.studentmanagement.entity.Student;
import org.hcltraining.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    public StudentService service;

    @PostMapping("/")
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
        return new ResponseEntity<Student>(service.saveStudent(student), HttpStatus.OK);
    }

    
}