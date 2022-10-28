package org.hcltraining.librarymanagement.service;

import java.util.List;

import org.hcltraining.librarymanagement.dao.LibraryDao;
import org.hcltraining.librarymanagement.dto.Book;
import org.hcltraining.librarymanagement.dto.BorrowBook;
import org.hcltraining.librarymanagement.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

	@Autowired
	LibraryDao libraryDao;

	public Book addBook(Book book) {
		return libraryDao.addBook(book);
	}

	public List<Book> getAllBooks(String authorName, String titleName) {

		return libraryDao.getAllBooks(authorName, titleName);
	}
	
	public String addBorrowDetails(BorrowBook borrowBook,int bookId) {
		
		return libraryDao.addBorrowDetails(borrowBook,bookId);
	}
	
	public String returnBook(int userId,int bookId) {
	
		return libraryDao.returnBook(userId, bookId);
	}
	
	public User addUser(User user) {
		return libraryDao.addUser(user);
	}
	
	public Book getBookById(int bookId) {
		return libraryDao.getBookById(bookId);
	}
	
	public Book updatedetails(Book book) {
		return libraryDao.updateDetails(book);
	}
	

}
