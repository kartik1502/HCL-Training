package org.training.manytomanymapping.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subId;
	private String subName;
	private String subAuthor;

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getSubAuthor() {
		return subAuthor;
	}

	public void setSubAuthor(String subAuthor) {
		this.subAuthor = subAuthor;
	}

	@Override
	public String toString() {
		return "\nSubject Id: " + getSubId() + "\nSubject Name: " + getSubName() + "\nSubject Author:"
				+ getSubAuthor() + "\n";
	}
	
}
