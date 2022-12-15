package org.training.studentmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.studentmanagement.entity.Student;
import org.training.studentmanagement.service.StudentService;

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