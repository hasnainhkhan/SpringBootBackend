//package com.spring.boot.web.service;
//
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.spring.boot.web.Entities.Author;
//import com.spring.boot.web.Entities.Books;
//import com.spring.boot.web.dao.BookRepo;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//
//@Transactional
//@Service // @components
//public class BookService {
//    
//    @PersistenceContext
//    private EntityManager entityManager;
//    
//    public List<Books> list;
//    private Books books;
//    
//    @Autowired
//    private BookRepo bookRepo;
//
//    // its call database method
//
////    private static List<Books> list = new ArrayList<>();
////    static {
////	list.add(new Books(10, "Java Reference", "xyz"));
////	list.add(new Books(12, "Python Reference", "mnk"));
////	list.add(new Books(16, "c Reference", "ijk"));
////    }
//
//    public List<Books> getAllBooks() {
//	return (List<Books>) bookRepo.findAll();
//    }
//
//    // get book by id
////    public Books getBooksById(int id) {
////	Books book = null;
////	
////    }
//
//    // get book by title
////    public Books getBooksByTitle(String title) {
////
////	return list.stream().filter(book -> book.getBookTitle().equalsIgnoreCase(title)).findFirst().orElseThrow();
////
////    }
//
//    // get book by author name
////    public Books getBookByAuthor(String author) {
////	return list.stream().filter(book -> book.getBookAuthor().equalsIgnoreCase(author)).findFirst().orElseThrow();
////    }
//
////	add book
//    @Transactional
//    public Books addBook(Books b) {
//	Author author = new Author();
//	if (author != null) {
//	        author = entityManager.merge(author);
//	 }
//	
//	book.setAuthor(author);
//	Books result = bookRepo.save(b);
//	
//
//	return result;
//    }
//
//    public void deleteBook(Books b) {
//	bookRepo.deleteAll();
//    }
//
//    public void deleteBookById(int id) {
//	bookRepo.deleteByBookId(id);
//    }
//
//    // update book
//    public Books updateBook(Books book,int id) {
//	 Books b = bookRepo.save(book);
//	 return b;
//    
//    }
//    }
//


package com.spring.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.boot.web.Entities.Author;
import com.spring.boot.web.Entities.Books;
import com.spring.boot.web.dao.BookRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//@Transactional
@Service
public class BookService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BookRepo bookRepo;

    // Method to get all books
    public List<Books> getAllBooks() {
        return (List<Books>) bookRepo.findAll();
    }

    // Method to add a book
    @Transactional
    public Books addBook(Books book) {
        // Get the Author from the Book object (check if it exists)
//        Author author = book.getAuthor();
//
//        // If the Author is not managed (detached), merge it to reattach
//        if (author != null && author.getA_id() != null) {
//            author = entityManager.merge(author); // Ensure the author is managed by the current session
//        }
//
//        // Set the author on the book object (this will also link the entities)
//        book.setAuthor(author);
	 Books managedBook = entityManager.merge(book);
	 entityManager.persist(managedBook);

        // Save the book object (with associated author)
        return bookRepo.save(book);
    }

    // Method to delete a book (by object)
    public void deleteBook(Books book) {
        bookRepo.delete(book);
    }

    // Method to delete a book by ID
    public void deleteBookById(int id) {
        bookRepo.deleteById(id);
    }

    // Method to update a book
    public Books updateBook(Books book, int id) {
        // Fetch the book by ID and update it
        Books existingBook = bookRepo.findById(id).orElseThrow();
        existingBook.setBookTitle(book.getBookTitle());
        existingBook.setAuthor(book.getAuthor()); // This ensures the author is updated
        // Save the updated book
        return bookRepo.save(existingBook);
    }
}
