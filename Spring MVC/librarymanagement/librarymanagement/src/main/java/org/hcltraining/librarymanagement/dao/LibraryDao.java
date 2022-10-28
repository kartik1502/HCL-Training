package org.hcltraining.librarymanagement.dao;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hcltraining.librarymanagement.dto.Book;
import org.hcltraining.librarymanagement.dto.BorrowBook;
import org.hcltraining.librarymanagement.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	public Book addBook(Book book) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(book);
		entityTransaction.commit();
		return entityManager.find(Book.class, book.getBookId());
	}

	public List<Book> getAllBooks(String authorName, String titleName) {

		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		List<Book> bookDetails = new ArrayList<>();

		if (titleName.length() > 0 && authorName.length() > 0) {

			Query query = entityManager.createQuery("select b from Book b");
			@SuppressWarnings("unchecked")
			List<Book> books = query.getResultList();
			for (Book book : books) {
				if (book.getName().startsWith(titleName) && book.getAuthorName().startsWith(authorName))
					bookDetails.add(book);
			}
		}

		else if (authorName.length() > 0) {
			Query query = entityManager.createQuery("select b from Book b");
			@SuppressWarnings("unchecked")
			List<Book> books = query.getResultList();
			for (Book book : books) {
				if (book.getAuthorName().startsWith(authorName))
					bookDetails.add(book);
			}
		} else if (titleName.length() > 0) {
			Query query = entityManager.createQuery("select b from Book b");
			@SuppressWarnings("unchecked")
			List<Book> books = query.getResultList();
			for (Book book : books) {
				if (book.getName().startsWith(titleName))
					bookDetails.add(book);
			}
		}
		return bookDetails;
	}

	public String addBorrowDetails(BorrowBook borrowBook, int bookId) {

		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		LocalDate date = LocalDate.now();
		User user = entityManager.find(User.class, borrowBook.getUserId());
		Book book = entityManager.find(Book.class, bookId);
		borrowBook.setBook(book);
		borrowBook.setDueDate(date.plusDays(10));
		if(user == null) {
			return "user";
		}
		else if(book == null) {
			return "book";
		}
		else {
			entityTransaction.begin();
			entityManager.persist(borrowBook);
			entityTransaction.commit();
			entityManager.find(BorrowBook.class, borrowBook.getBorrowId());
			return "borrow";
		}
		

	}
	
	public String returnBook(int userId, int bookId) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		User user = entityManager.find(User.class, userId);
		Book book = entityManager.find(Book.class, bookId);
		if(user == null) {
			return "user";
		}
		else if(book == null) {
			return "book";
		}
		else {
			TypedQuery<BorrowBook> query = entityManager.createQuery("select bb from BorrowBook bb where bb.userId = :userId", BorrowBook.class);
			List<BorrowBook> books = query.setParameter("userId",userId).getResultList();
			BorrowBook borrowBooks = new BorrowBook();
			for (BorrowBook borrowBook : books) {
				if(book.getBookId() == borrowBook.getBook().getBookId()) {
					borrowBooks = borrowBook;
				}
			}
			borrowBooks.setStatus("Returned");
			entityTransaction.begin();
			entityManager.persist(borrowBooks);
			entityTransaction.commit();
			return "true";
		}
	}
	
	public User addUser(User user) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return entityManager.find(User.class, user.getUserId());
	}
	
	public Book getBookById(int bookId) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Book book = entityManager.find(Book.class, bookId);
		entityTransaction.commit();
		return book;
	}
	
	public Book updateDetails(Book book) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Book book2 = entityManager.find(Book.class, book.getBookId());
		book2.setName(book.getName());
		book2.setAuthorName(book.getAuthorName());
		book2.setPublishYear(book.getPublishYear());
		book2.setGenre(book.getGenre());
		entityManager.persist(book2);
		entityTransaction.commit();
		return book2;
	}

}
