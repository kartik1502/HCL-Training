package com.javaproject.javaoopsconcept;

import java.io.Serializable;

public class Book implements Serializable{
	public String bookName;
	public int bookId;
	public int price;
	public String authorName;
	public Book() {}
	public Book(String bookName,int bookId) {
		this.bookName = bookName;
		this.bookId = bookId;
	}
	public Book(String bookName, int bookId, int price) {
		this(bookName,bookId);
		this.price = price;
	}
	public Book(String bookName, int bookId, int price,String authorName) {
		this(bookName,bookId,price);
		this.authorName = authorName;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", bookId=" + bookId + ", price=" + price + ", authorName=" + authorName
				+ "]";
	}
	
}
