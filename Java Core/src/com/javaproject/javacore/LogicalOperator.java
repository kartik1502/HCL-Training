package com.javaproject.javacore;
public class LogicalOperator {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        boolean c = (a > b) && (a < b);
        boolean d = (20 > 10) && (19 < 23);
        System.out.println(c);
        System.out.println(d);
        boolean e = 20 > 10;
        System.out.println(e);
        System.out.println(!true);
        System.out.println(!false);
        System.out.println(((a > b) && (a < b)) || 10 < 8);
        
    }
}
