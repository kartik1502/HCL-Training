package org.hcltraining.studentmanagement.controller;

import org.hcltraining.studentmanagement.dto.Student;
import org.hcltraining.studentmanagement.repository.StudentRepository;
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
    public String deleteById(@PathVariable(value = "studentId")int studentId){
        service.deleteById(studentId);
        return "Deleted";
    }

    @GetMapping("/findByStudentName/{studentName}")
    public Student findByStudentName(@PathVariable(value = "studentName")String studentName){
        return service.findByStudentName(studentName);
    }

    @DeleteMapping("/deleteByStudentName/{studentName}")
    public void deleteByStudentName(@PathVariable(value = "studentName")String studentName){
        service.deleteByStudentName(studentName);
    }

    @GetMapping("/getAllStudentByAge/{start}/{end}")
    public List<Student> findAllStudentByAge(@PathVariable(value = "start") int start,@PathVariable(value = "end") int end){
        return service.findAllByStudentAge(start,end);
    }

    @GetMapping("findStudentByStudentNameStarting/{studentName}")
    public List<Student> findStudentByStudentNameStarting(@PathVariable(value = "studentName")String studentName){
        return service.findStudentByStudentNameStartingWith(studentName);
    }

    @GetMapping("/findAllStudentOrderByStudentName")
    public List<Student> findAllStudentOrderByStudentName(){
        return service.findAllStudentOrderByStudentName();
    }

    @GetMapping("/findStudentNameLike/{studentName}")
    public List<Student> findStudentNameLike(@PathVariable(value = "studentName")String studentName){
        return service.findStudentNameLike(studentName);
    }

}
