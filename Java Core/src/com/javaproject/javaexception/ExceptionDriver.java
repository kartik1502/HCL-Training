package com.javaproject.javaexception;

public class ExceptionDriver extends Parent{
	public static void main(String[] args) {
		
		try{
			Parent p = new Parent();
			ExceptionDriver ed = new ExceptionDriver();
			ed = (ExceptionDriver) p;
			ed.display();
		}
		catch(ClassCastException e){
			e.printStackTrace();
		}
		
	}
}
