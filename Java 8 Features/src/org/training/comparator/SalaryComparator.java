package org.training.comparator;

import java.util.Comparator;

public class SalaryComparator implements Comparator {

    public int compare(Object o1,Object o2){

        Employee employee = (Employee) o1;
        Employee employee1 = (Employee) o2;

        if(employee.salary == employee1.salary)
            return 0;
        else if (employee.salary > employee1.salary) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
