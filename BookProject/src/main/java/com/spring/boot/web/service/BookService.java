package com.spring.boot.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.web.Entities.Books;
import com.spring.boot.web.dao.BookRepo;

@Service // @components
public class BookService {
    
    public List<Books> list;
    private Books books;
    
    @Autowired
    private BookRepo bookRepo;

    // its call database method

//    private static List<Books> list = new ArrayList<>();
//    static {
//	list.add(new Books(10, "Java Reference", "xyz"));
//	list.add(new Books(12, "Python Reference", "mnk"));
//	list.add(new Books(16, "c Reference", "ijk"));
//    }

    public List<Books> getAllBooks() {
	return (List<Books>) bookRepo.findAll();
    }

    // get book by id
//    public Books getBooksById(int id) {
//	Books book = null;
//	
//    }

    // get book by title
//    public Books getBooksByTitle(String title) {
//
//	return list.stream().filter(book -> book.getBookTitle().equalsIgnoreCase(title)).findFirst().orElseThrow();
//
//    }

    // get book by author name
//    public Books getBookByAuthor(String author) {
//	return list.stream().filter(book -> book.getBookAuthor().equalsIgnoreCase(author)).findFirst().orElseThrow();
//    }

//	add book
    public Books addBook(Books b) {
	Books result = bookRepo.save(b);
	return result;
    }

    public void deleteBook(Books b) {
	bookRepo.deleteAll();
    }

    public void deleteBookById(int id) {
	bookRepo.deleteByBookId(id);
    }

    // update book
    public Books updateBook(Books book,int id) {
	 Books b = bookRepo.save(book);
	 return b;
    
    }
    }

