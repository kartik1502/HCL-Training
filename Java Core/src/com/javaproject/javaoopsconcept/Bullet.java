package com.javaproject.javaoopsconcept;

public class Bullet {
	private double price;
	private double size;
	private String color;
	public Bullet(double price, double size, String color) {
		this.price = price;
		this.size = size;
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Bullet Price: " + getPrice() + "\nBullet Size: " + getSize() + "\nBullet Color: " + getColor();
	}
	
	
	
	
	
}
