package org.hcltraining.aadharmanagement.dto;

public class UserResponse {
	
	private long count;
	
	private String aadharNumber;
	
	

	public UserResponse(long count, String aadharNumber) {
		super();
		this.count = count;
		this.aadharNumber = aadharNumber;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	
	

	

	
	

}
