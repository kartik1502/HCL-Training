package com.javaproject.multithreading;

public class ThreadTwo implements Runnable{

	MyThread myThread;

	
	
	public ThreadTwo(MyThread myThread) {
		super();
		this.myThread = myThread;
	}

	public void run() {
		myThread.Print();
	}
}
