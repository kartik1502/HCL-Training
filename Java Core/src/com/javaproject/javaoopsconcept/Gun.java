package com.javaproject.javaoopsconcept;

public class Gun {
	String gunColor;
	double gunPrice;
	Bullet b;
	
	public Gun(String gunColor, double gunPrice, Bullet b) {
		this.gunColor = gunColor;
		this.gunPrice = gunPrice;
		this.b = b;
	}

	public String getGunColor() {
		return gunColor;
	}

	public void setGunColor(String gunColor) {
		this.gunColor = gunColor;
	}

	public double getGunPrice() {
		return gunPrice;
	}

	public void setGunPrice(double gunPrice) {
		this.gunPrice = gunPrice;
	}

	public Bullet getB() {
		return b;
	}

	public void setB(Bullet b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "Gun Color: " + getGunColor() + "\nGun Price: " + getGunPrice() + "\nBullet Details:\n" + getB().toString();
	}

	
	
}
