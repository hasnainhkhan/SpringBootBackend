package com.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.spring.boot.web.Entities.Books;
import com.spring.boot.web.service.BookService;

import lombok.Delegate;


@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/allbooks")
	public List<Books> getBooks() {
		List<Books> books = bookService.getAllBooks();
		return books;
	}

	@GetMapping("/allbooks/{id}")
	public Books getSingleBook(@PathVariable("id") int id) {
		Books book = bookService.getBooksById(id);
		return book;

	}

	@GetMapping("/allbooks/authors/{author}")
	public Books getBookByAuthor(@PathVariable("author") String author) {
		return bookService.getBookByAuthor(author);
	}

	@GetMapping("/allbooks/title/{title}")
	public Books getBooksByTitle(@PathVariable("title") String title) {
		Books book = bookService.getBooksByTitle(title);
		return book;
	}

	@PostMapping("/books")
	public Books addBook(@RequestBody Books book) {
		Books b = this.bookService.addBook(book);
		return b;
	}
	@DeleteMapping("/books/del")
	public Books deleteBook(@RequestBody Books book) {
		Books b = this.bookService.deleteBook(book);
		return b;
	}
	@DeleteMapping("/books/del/{id}")
	public Books deleteBookByID(@PathVariable("id") int id) {
		Books b = this.bookService.deleteBookById(id);
		return b;
	}
	//update api
	@PutMapping("/allbooks/{id}")
	public Books updateBook(@RequestBody Books book,@PathVariable("id") int id) {
		this.bookService.updateBook(book,id);
		return book;		
	}

}
