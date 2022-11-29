package org.training.comparable;

public class Student implements Comparable<Student>{

    int studId;
    String name;
    int age;

    public Student(int studId, String name, int age) {
        this.studId = studId;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student s) {
        if(this.name == s.name)
            return 0;
        else if (this.name.compareTo(s.name) < 0) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
