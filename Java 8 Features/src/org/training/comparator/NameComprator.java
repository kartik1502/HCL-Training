package org.training.comparator;

import java.util.Comparator;

public class NameComprator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Employee employee = (Employee) o1;
        Employee employee1 = (Employee) o2;

        return employee.name.compareTo(employee1.name);

    }
}
