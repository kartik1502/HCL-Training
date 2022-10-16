package org.hcltraining.unittesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJunit {

	String message = "Hi Boss";
	MessageUtil messageUtil = new MessageUtil(message);
	
	@Test
	public void printTestMessage() {
		//message = "Hi Karthik";
		assertEquals(message, messageUtil.printMesssage());
	}
}
