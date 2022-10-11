package com.javaproject.javaoopsconcept;

public class Sim {
	
	private String serviceProvider;
	private long simNumber;
	private String color;
	
	public Sim(String serviceProvider, long simNumber) {
		this.serviceProvider = serviceProvider;
		this.simNumber = simNumber;
	}
	public Sim(String serviceProvider, long simNumber, String color) {
		this(serviceProvider,simNumber);
		this.color = color;
	}
	
	public String getServiceProvider() {
		return serviceProvider;
	}
	public long getSimNumber() {
		return simNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Service Provider: " + getServiceProvider() + "\nSim Number: " + getSimNumber()
				+ "\nColor: " + getColor();
	}
}
