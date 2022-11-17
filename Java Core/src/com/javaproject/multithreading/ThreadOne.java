package com.javaproject.multithreading;

public class ThreadOne implements Runnable {

	MyThread myThread;

	public ThreadOne(MyThread myThread) {
		super();
		this.myThread = myThread;
	}
	
	public void run() {
		myThread.Print();
	}
	
}
