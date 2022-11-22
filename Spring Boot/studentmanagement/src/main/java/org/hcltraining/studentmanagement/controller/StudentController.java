package org.hcltraining.studentmanagement.controller;

import org.hcltraining.studentmanagement.entity.Student;
import org.hcltraining.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/findByStudentName")
    public Student findByStudentName(@RequestParam String studentName){
        return service.findByStudentName(studentName);
    }

    @DeleteMapping("/deleteByStudentName")
    public void deleteByStudentName(@RequestParam String studentName){
        service.deleteByStudentName(studentName);
    }

    @GetMapping("/getAllStudentByAge")
    public List<Student> findAllStudentByAge(@RequestParam int start,@RequestParam int end){
        return service.findAllByStudentAge(start,end);
    }

    @GetMapping("findStudentByStudentNameStarting")
    public List<Student> findStudentByStudentNameStarting(@RequestParam String studentName){
        return service.findStudentByStudentNameStartingWith(studentName);
    }

    @GetMapping("/findAllStudentOrderByStudentName")
    public List<Student> findAllStudentOrderByStudentName(){
        return service.findAllStudentOrderByStudentName();
    }

    @GetMapping("/findStudentNameContains")
    public List<Student> findStudentNameLike(@RequestParam String studentName){
        return service.findStudentNameContains(studentName);
    }

    @GetMapping("/getAllStudentPaginated")
    public List<Student> getAllStudentsPaginated(@RequestParam int pageNo,@RequestParam int pageSize){
        return service.getAllStudentPaginated(pageNo,pageSize);
    }

    @GetMapping("/getStudentAfter")
    public List<Student> getAllStudentsAfter(@RequestParam String date){
        return service.getAllStudentsAfter(date);
    }

    @GetMapping("/getStdentAgeGreaterThan")
    public List<Student> getAllStudentAgeGreaterThan(@RequestParam int age){
        return service.getAllStudentAgeGreaterThan(age);
    }

    @GetMapping("/getStudentNameOrAge")
    public List<Student> getStudentByNameOrAge(@RequestParam String studentName,@RequestParam int age){
        return service.getAllStudentByStudentNameOrAge(studentName,age);
    }

    @GetMapping("/getAllStudentAgeIn")
    public List<Student> getStudentAgeIn(@RequestParam List<Integer> ages){
     
        return service.getAllStudentAgeIn(ages);
    }

    @GetMapping("/getStudentNameEnding")
    public List<Student> getStudentNameEnding(@RequestParam String studentName){
        return service.getStudentNameEnding(studentName);
    }

    @GetMapping("/getStudentNameIgnoreCase")
    public List<Student> getStudentNameIgnoreCase(String studentName){
        return service.getStudenNameIgnoreCase(studentName);
    }

}
