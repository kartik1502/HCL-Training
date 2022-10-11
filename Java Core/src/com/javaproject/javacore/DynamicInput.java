package com.javaproject.javacore;
import java.util.Scanner;
public class DynamicInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the integer:");
        int a = sc.nextInt();
        System.out.println("The integer is: "+a);
        System.out.println("Enter the float:");
        float b = sc.nextFloat();
        System.out.println("The float number is: "+b);
        System.out.println("Enter the boolean:");
        boolean c = sc.nextBoolean();
        System.out.println("The boolean is: "+c);
        System.out.println("Enter the short:");
        short d = sc.nextShort();
        System.out.println("The short is: "+d);
        System.out.println("Enter the byte:");
        byte e = sc.nextByte();
        System.out.println("The byte is: "+e);
        sc.close();
    }    
}
