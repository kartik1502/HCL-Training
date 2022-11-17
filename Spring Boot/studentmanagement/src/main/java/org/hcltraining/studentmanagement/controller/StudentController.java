package org.hcltraining.studentmanagement.controller;

import org.hcltraining.studentmanagement.dto.Student;
import org.hcltraining.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    public StudentService service;

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping("/getById/{studentId}")
    public Student getById(@PathVariable(value = "studentId")int studentId){
        return service.getById(studentId);
    }

    @PutMapping("/updateStudent/{studentId}")
    public Student updateStudent(@RequestBody Student student,@PathVariable(value = "studentId")int studentId){
        return service.updateStudent(student,studentId);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @DeleteMapping("/deleteById/{studentId}")
    public void deleteById(@PathVariable(value = "studentId")int studentId){
        service.deleteById(studentId);
    }

}
