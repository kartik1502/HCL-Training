package com.javaproject.javaoopsconcept;

public class SimProvider {

	public static void main(String[] args) {
		
		Sim s = new Sim("Jio",6361921186l,"Red");
		System.out.println(s.getServiceProvider());
		System.out.println(s.getSimNumber());
		System.out.println(s.getColor());
		s.setColor("Blue");
		System.out.println(s.getColor());

	}

}