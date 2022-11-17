package com.javaproject.javacore;

import java.util.Scanner;

public class Evaluation {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean flag = false;
		int num1 = 0,num2 = 0;
		String op = " ";
		for(int i = 0;i < str.length();i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				if(!flag) {
					
					num1 = num1 * 10 + Character.getNumericValue(str.charAt(i));
				}
				else {
					num2 = num2 * 10 + Character.getNumericValue(str.charAt(i));;
				}
			}
			else if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
				op = String.valueOf(str.charAt(i));
				flag = true;
			}
		}
		switch(op) {
			case "+" : System.out.println(num1+num2);
					break;
			case "-" : System.out.println(num1-num2);
			break;
			case "*" : System.out.println(num1*num2);
			break;
			case "/" : System.out.println(num1/num2);
			break;
		}
		
	}
}
