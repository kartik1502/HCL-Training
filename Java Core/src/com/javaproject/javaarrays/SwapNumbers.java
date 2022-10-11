package com.javaproject.javaarrays;

import java.util.Scanner;

public class SwapNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the two numbers: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = 0;
		System.out.println(a+""+b);
		c = a;
		a = b;
		b = c;
		System.out.println(a+""+b);
	}
}
