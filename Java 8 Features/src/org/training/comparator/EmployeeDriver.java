package org.training.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDriver {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Mahesh",50000,"mahesh@gmail.com"));
        employees.add(new Employee(2,"Arya",48000,"arya@gmail.com"));
        employees.add(new Employee(3,"Girish",68000,"girish@gmail.com"));
        employees.add(new Employee(4,"Prasad",39000,"prasad@gmail.com"));

        Collections.sort(employees, new NameComprator());
        System.out.println("Name Comparator");
        for (Employee e : employees) {
            System.out.println(e.empid+" "+e.name+" "+e.salary+" "+e.email);
        }

        Collections.sort(employees, new SalaryComparator());
        System.out.println("Salary Comparator");
        for (Employee e : employees) {
            System.out.println(e.empid+" "+e.name+" "+e.salary+" "+e.email);
        }

    }
}
