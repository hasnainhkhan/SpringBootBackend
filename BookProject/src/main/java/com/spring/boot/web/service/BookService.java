package com.spring.boot.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.web.Entities.Books;

@Service //@components
public class BookService {
	//its call database method
	
	private static List<Books> list = new ArrayList<>();
	static {
		list.add(new Books(10,"Java Reference","xyz"));
		list.add(new Books(12,"Python Reference","mnk"));
		list.add(new Books(16,"c Reference","ijk"));
	}
	public List<Books> getAllBooks(){
		return list;
	}
	
	//get book by id
	public Books getBooksById(int id) {
		Books book = null;
		book = list.stream().filter(e->e.getBookId()==id).findFirst().get();
		return book;
		
	}
	
	//get book by title
	public Books getBooksByTitle(String title){
		
		return list.stream().filter(book->book.getBookTitle()
				.equalsIgnoreCase(title))
				.findFirst()
				.orElseThrow();
				
		 
		
	}
	
	//get book by author name
	public Books getBookByAuthor(String author) {
	    return list.stream()
	               .filter(book -> book.getBookAuthor().equalsIgnoreCase(author))
	               .findFirst()
	               .orElseThrow();
	}
	
//	add book
	public Books addBook(Books b) {
		list.add(b);
		return b;
	}
	public Books deleteBook(Books b) {
		list.remove(b);
		return b;
	}
	public Books deleteBookById(int id) {
		    Books bookToRemove = null;
		    for (Books book : list) {
		        if (book.getBookId() == id) {
		            bookToRemove = book;
		            break;
		        }
		    }

		    if (bookToRemove != null) {
		        list.remove(bookToRemove);
		    }

		    return bookToRemove;
	}
		//update books
		public void updateBook(Books book,int id) {
		list.stream().map(b->{
			if (b.getBookId()==id) {
				b.setBookAuthor(book.getBookAuthor());
				b.setBookTitle(book.getBookTitle());
			}
			return book;
			}).collect(Collectors.toList());
		
	}
}
