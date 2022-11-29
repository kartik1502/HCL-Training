package org.training.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Karthik",23));
        students.add(new Student(2,"Adam",22));
        students.add(new Student(3,"Kotappa",21));
        students.add(new Student(4,"Jayanth",26));
        Collections.sort(students);
        for (Student s :
                students) {
            System.out.println(s.studId+" "+s.name+" "+s.age);
        }
    }
}