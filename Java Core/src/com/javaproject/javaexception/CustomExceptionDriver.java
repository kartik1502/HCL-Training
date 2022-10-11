package com.javaproject.javaexception;

import java.util.Scanner;

public class CustomExceptionDriver {

	public static void main(String[] args) throws CustomException,PasswordException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the age: ");
		int age = sc.nextInt();
		if(age < 18){
			throw new CustomException("Below age limit");
		}
		System.out.println("Enter the password:");
		String pswd = sc.next();
		if(pswd.length() < 8)
			throw new PasswordException("Length less than 8");
		
	}

}
