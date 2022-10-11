package com.javaproject.javaoopsconcept;

public class Heart {
	String heartColor = "Red";
	double price = 100000;
	String brand = "TATA";
	public Heart() {}
	public Heart(String heartColor, double price, String brand) {
		this.heartColor = heartColor;
		this.price = price;
		this.brand = brand;
	}
	public void heartDisplay() {
		System.out.println("Heart Color: "+heartColor+"\nPrice: "+price+"\nBrand: "+brand);
	}
}
