package com.javaproject.javacore;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int a = sc.nextInt();
        System.out.println("Enter the operator:");
        char op = sc.next().charAt(0);
        System.out.println("Enter the second number:");
        int b = sc.nextInt();
        switch(op){
            case '+':
                System.out.println("Result is: "+(a+b));
                break;
            case '-':
                System.out.println("Result is: "+(a-b));
                break;
            case '*':
                System.out.println("Result is: "+(a*b));
                break;
            case '/':
                System.out.println("Result is: "+(a/b));
                break;
            case '%':
                System.out.println("Result is: "+(a%b));
                break;
            default:System.err.println("Invalid operator!!!!");
        }
        sc.close();
    }    
}
