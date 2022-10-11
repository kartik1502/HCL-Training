package com.javaproject.javaoopsconcept;

public class GunDriver {

	public static void main(String[] args) {
		Bullet b = new Bullet(5000,5.56d,"Metal");
		Gun g = new Gun("Gun Metal",25000,b);
		System.out.println(g);
		g.getB().setPrice(2500);
		System.out.println(g);
	}

}
