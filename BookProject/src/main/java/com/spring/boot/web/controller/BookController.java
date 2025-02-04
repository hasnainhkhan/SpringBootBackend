package com.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.spring.boot.web.Entities.Books;
import com.spring.boot.web.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/allbooks")
	public ResponseEntity<List<Books>> getBooks() {

		List<Books> list = bookService.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

//	@GetMapping("/allbooks/{id}")
//	public ResponseEntity<Books> getSingleBook(@PathVariable("id") int id) {
//		Books book = bookService.getBooksById(id);
//		if (book == null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.of(Optional.of(book));
//
//	}

//	@GetMapping("/allbooks/authors/{author}")
//	public ResponseEntity<Books> getBookByAuthor(@PathVariable("author") String author) {
//		Books book = bookService.getBookByAuthor(author);
//		if (book == null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.of(Optional.of(book));
//	}

//	@GetMapping("/allbooks/title/{title}")
//	public ResponseEntity<Books> getBooksByTitle(@PathVariable("title") String title) {
//		Books book = bookService.getBooksByTitle(title);
//		if(book == null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.of(Optional.of(book));
//	}

	@PostMapping("/allbooks")
	public ResponseEntity<Books> addBook(@RequestBody Books book) {
		Books b = null;
		try {
			b = this.bookService.addBook(book);
			return ResponseEntity.of(Optional.of(book));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/allbooks/")
	public ResponseEntity<Void> deleteBook(@RequestBody Books book) {
		try {
			this.bookService.deleteBook(book);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/allbooks/{id}")
	public ResponseEntity<Void> deleteBookByID(@PathVariable("id") int id) {
		try {
			this.bookService.deleteBookById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/allbooks/{id}")
	public ResponseEntity<Void> updateBook(@RequestBody Books book, @PathVariable("id") int id) {
		try {
			this.bookService.updateBook(book,id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
