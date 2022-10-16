package org.hcltraining.unittesting;

public class MessageUtil {

	private String message;

	public MessageUtil(String message) {
		super();
		this.message = message;
	}

	public String printMesssage() {
		System.out.println(message);
		return message;
	}
	
	
}
