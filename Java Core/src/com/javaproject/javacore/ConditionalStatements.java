package com.javaproject.javacore;
import java.util.Scanner;

public class ConditionalStatements {
    public static void main(String[] args) {
    	System.out.println("if-else condition example");
        System.out.println("main starts");
        if(false)
            System.out.println("if is executing");
        else
            System.out.println("else is executing");
        System.out.println("main is executing");
        if(true)
            System.out.println("if is executing");
        System.out.println("main ends");
		System.out.println("--------------------------------------");
        int a = 20;
        int b = 30;
        System.out.println("Greatest of two numbers");
        if(a > b)
        	System.out.println("a is greatest");
        else
 			System.out.println("b is greatest");
		System.out.println("--------------------------------------");
 		System.out.println("Smallest of two numbers");
 		if(a < b)
 			System.out.println("a is smallest");
 		else
 			System.out.println("b is smallest");   
		System.out.println("--------------------------------------");
		System.out.println("else-if condition example");
 		if(true)
 			System.out.println("else-if condition is executing");
 		else
 			System.out.println("else is executing");
 		System.out.println("main is executing");  
		System.out.println("--------------------------------------");		 
 		System.out.println("Greatest of three numbers"); 	
 		int c = 46;
 		if(a > b && a > c)
 			System.out.println("a is greatest");
 		else if(b > c)
 			System.out.println("b is greatest");
 		else
 			System.out.println("c is greatest");
			 System.out.println("--------------------------------------");
 		System.out.println("Greatest of five numbers");
 		int d = 12;
 		int e = 63;
 		if(a > b && a > c && a > d && a > e)
 			System.out.println("a is greatest");
 		else if(b > c && b > d && b > e)
 			System.out.println("b is greatest");
 		else if(c > d && c > e)
 			System.out.println("c is greatest");
 		else if(d > e)
 			System.out.println("d is greatest");
 		else
 			System.out.println("e is greatest");
			 System.out.println("--------------------------------------");	
		System.out.println("Is character a alphabet or number or special character?");
		char ch = '#';
		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
			System.out.println(ch +" is a alphabet");
		else if(ch > 47 && ch < 58 )
			System.out.println(ch +" is a number");
		else 
			System.out.println(ch+" is special character");	
			System.out.println("--------------------------------------");
		System.out.println("Is a leap year or not?");
		int year = 1900;
		if((year % 4 == 0 && year % 100 != 0)|| year % 400 == 0)
			System.out.println(year+" is a leap year");
		else
			System.out.println(year+" is not a leap year");
			System.out.println("--------------------------------------");
		System.out.println("Greatest of three nested-if condition");
		if(a > b){
			if(a > c)
				System.out.println(a+" is greatest");
			else
				System.out.println(c+" is greatest");
		}
		else{
			if(b > c)
				System.out.println(b+" is greatest");
			else
				System.out.println(c+" is greatest");
		}
		System.out.println("--------------------------------------");
		System.out.println("Switch case example");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the month number:");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:System.out.println("It has 31 days");
				break;
			case 2:System.out.println("It has 28/29 days");
				break;
			case 4:
			case 6:
			case 9:
			case 11:System.out.println("It has 30 days");
		default:System.out.println("Invalid choice!!!");
		}
		sc.close();
	}
}
