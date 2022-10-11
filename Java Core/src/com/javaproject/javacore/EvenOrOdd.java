package com.javaproject.javacore;
public class EvenOrOdd {
    public static void main(String[] args) {
	int a = 24;
        int b = 86;
        int c = 56;
	System.out.println((a%2 == 0) ? "a is even" : "b is even");
        System.out.println(((a>b) && (a > c)) ? "a is greatest" : (b > c) ? "b is greatest" : "c is greatest");
    }
}
