package com.javaproject.multithreading;

public class ThreadRunner {

	public static void main(String[] args) {
		
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(new ThreadOne(myThread));
		Thread t2 = new Thread(new ThreadTwo(myThread));
		t1.start();
		t2.start();
	}
}
