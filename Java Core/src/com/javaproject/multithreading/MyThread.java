package com.javaproject.multithreading;

public class MyThread  {
	
	synchronized public void Print() {
		
		for(int i = 0;i < 5;i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
