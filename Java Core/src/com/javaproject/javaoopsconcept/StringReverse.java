package com.javaproject.javaoopsconcept;

import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String: ");
		String OrgStr = sc.next();
		char[] RevStr = new char[OrgStr.length()];
		int j = 0;
		for(int i = OrgStr.length() - 1;i >= 0;i--){
			RevStr[j++] = OrgStr.charAt(i);
		}
		String result = new String(RevStr);
		System.out.println(result);
	}

}