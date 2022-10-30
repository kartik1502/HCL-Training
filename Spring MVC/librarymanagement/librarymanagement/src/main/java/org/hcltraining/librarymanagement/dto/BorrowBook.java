package org.hcltraining.librarymanagement.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import org.springframework.stereotype.Component;

@Entity
@Component
public class BorrowBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int borrowId;
	@OneToOne
	private User user;
	private LocalDate dueDate;
	@OneToOne
	private Book book;
	@CreationTimestamp
	private Date borrowDate;
	private String status;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate localDate) {
		this.dueDate = localDate;
	}
	
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
