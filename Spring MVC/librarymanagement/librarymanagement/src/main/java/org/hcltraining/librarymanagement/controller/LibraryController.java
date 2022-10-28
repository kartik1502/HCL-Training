package org.hcltraining.librarymanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.hcltraining.librarymanagement.dto.Book;
import org.hcltraining.librarymanagement.dto.BorrowBook;
import org.hcltraining.librarymanagement.dto.User;
import org.hcltraining.librarymanagement.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class LibraryController {

	@Autowired
	LibraryService libraryService;

	@RequestMapping("/addBook")
	public ModelAndView addBook(@ModelAttribute Book book) {
		Book book2 = libraryService.addBook(book);
		ModelAndView modelAndView = new ModelAndView("message.jsp");
		if (book2 != null) {
			modelAndView.addObject("msg", "Book Saved Successfully");

		} else {
			modelAndView.addObject("msg", "Book was not saved");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/addUser")
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		
		ModelAndView view = new ModelAndView("message.jsp");
		User user2 = libraryService.addUser(user);
		if(user2 == null) {
			view.addObject("msg","User was not added");
		}
		else {
			view.addObject("msg","User added Successfully");
		}
		return view;
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView updateBook(@RequestParam("bookId") int bookId) {
		
		ModelAndView view = new ModelAndView("updateDetails.jsp");
		Book book = libraryService.getBookById(bookId);
		view.addObject("bookId", book.getBookId());
		view.addObject("bookTitle" , book.getName());
		view.addObject("authorName", book.getAuthorName());
		view.addObject("publishYear", book.getPublishYear());
		view.addObject("genre", book.getGenre());
		return view;
	}
	
	@RequestMapping(value = "/updateDetails")
	public ModelAndView updateDetails(@ModelAttribute("book") Book book) {
		
		ModelAndView view = new ModelAndView("message.jsp");
		Book book2 = libraryService.updatedetails(book);
		if(book2 == null) {
			view.addObject("msg", "Book details was not updated");
		}
		else {
			view.addObject("msg", "Book details updated Successfully");
		}
		return view;
	}
	
	
	
	@RequestMapping("/display")
	public ModelAndView search(@ModelAttribute("book") Book book) {

		List<Book> books = libraryService.getAllBooks(book.getAuthorName(), book.getName());
		if (books == null) {
			ModelAndView home = new ModelAndView("message.jsp");
			return home;
		}
		ModelAndView view = new ModelAndView("SearchBook.jsp");
		return view.addObject("getBooks", books);
	}
	
	@RequestMapping(value = "/borrowed")
	public ModelAndView borrowBook(@RequestParam("userId") int userId,@RequestParam("bookId") int bookId,@RequestParam("status") String status) {
		BorrowBook book = new BorrowBook();
		book.setUserId(userId);
		book.setStatus(status);
		String response = libraryService.addBorrowDetails(book,bookId);
		ModelAndView modelAndView = new ModelAndView("message.jsp");
		if (response.equals("user")) {
			modelAndView.addObject("msg","Invalid User!!! Please register");

		} 
		else if(response.equals("book")){
			modelAndView.addObject("msg","Requested book not avaliable");
		}
		else {
			modelAndView.addObject("msg","Borrowed Status updated Successfully");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/returnBook")
	public ModelAndView returnBook(@RequestParam("userId") int userId, @RequestParam("bookId") int bookId) {
		
		ModelAndView view = new ModelAndView("message.jsp");
		String response = libraryService.returnBook(userId, bookId);
		if(response.equals("true")) {
			return view.addObject("msg", "Book Returned Successfully");
		}
		else if(response.equals("user")) {
			return view.addObject("msg", "User Id is not valid");
		}
		else {
			return view.addObject("msg", "Book was not borrowed");
		}
	}
	
	

}
