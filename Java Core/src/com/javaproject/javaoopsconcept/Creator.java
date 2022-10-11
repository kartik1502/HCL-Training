package com.javaproject.javaoopsconcept;

public class Creator {

	public static void main(String[] args) {
		Heart heart = new Heart("Red",150000,"BMW");
		Human h = new Human("Karthik", 23, "B+", heart);
		h.humanDisplay();
		heart.heartDisplay();
	}

}
