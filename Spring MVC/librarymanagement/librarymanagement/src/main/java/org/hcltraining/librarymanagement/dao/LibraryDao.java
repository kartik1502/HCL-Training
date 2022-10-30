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

	private void getManager() {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
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

	public String addBorrowDetails(BorrowBook borrowBook, int bookId, int userId) {

		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		LocalDate date = LocalDate.now();
		User user = entityManager.find(User.class, userId);
		Book book = entityManager.find(Book.class, bookId);
		if(user == null) {
			return "user";
		}
		else if(book == null) {
			return "book";
		}
		else {
			book.setNoOfCopies(book.getNoOfCopies() - 1);
			borrowBook.setBook(book);
			borrowBook.setDueDate(date.plusDays(10));
			entityTransaction.begin();
			entityManager.persist(borrowBook);
			entityManager.persist(book);
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
			Query query = entityManager.createQuery("select bb from BorrowBook bb");
			@SuppressWarnings("unchecked")
			List<BorrowBook> books = query.getResultList();
			BorrowBook borrowBooks = new BorrowBook();
			for (BorrowBook borrowBook : books) {
				if(book.getBookId() == borrowBook.getBook().getBookId() && user.getUserId() == borrowBook.getUser().getUserId()) {
					borrowBooks = borrowBook;
				}
			}
			book.setNoOfCopies(book.getNoOfCopies() + 1);
			borrowBooks.setStatus("Returned");
			entityTransaction.begin();
			entityManager.persist(borrowBooks);
			entityManager.persist(book);
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
	
	public User getUserById(int userId) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		User user = entityManager.find(User.class, userId);
		entityTransaction.commit();
		return user;
	}
	
	public List<Book> getBooks(){
		
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select b from Book b");
		@SuppressWarnings("unchecked")
		List<Book> books = query.getResultList();
		return books;
		
	}
	
	public List<User> getAllUsers(){
		getManager();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select u from User u");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		entityTransaction.commit();
		return users;
	}
	
	public List<BorrowBook> borrowStatus(){
		
		getManager();
		entityTransaction.begin();
		Query query = entityManager.createQuery("select bb from BorrowBook bb");
		@SuppressWarnings("unchecked")
		List<BorrowBook> books = query.getResultList();
		entityTransaction.commit();
		return books;
	}

}
