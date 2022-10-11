package com.javaproject.javaexception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedException {
	public static void main(String[] args) {
		CheckedException ce = new CheckedException();
		ce.m1();
	}
	public void m1(){
		System.out.println("Hii");
		try{
			FileInputStream fp = new FileInputStream("");
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
