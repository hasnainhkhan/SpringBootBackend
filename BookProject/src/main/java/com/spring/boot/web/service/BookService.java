package com.spring.boot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.boot.web.Entities.Books;
import com.spring.boot.web.dao.BookRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Service
public class BookService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BookRepo bookRepo;

    // Method to add a book with Optimistic Locking
    @Transactional
    public Books addBook(Books book) {
        // Merging the book with the session (automatically handles the version field)
        Books managedBook = entityManager.merge(book);
        // Save the book with the updated version
        return bookRepo.save(managedBook);
    }

    // Method to update a book with Optimistic Locking
    @Transactional
    public Books updateBook(Books book, int id) {
        try {
            // Fetch the book by ID and ensure the version is checked before updating
            Books existingBook = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
            existingBook.setBookTitle(book.getBookTitle());
            existingBook.setAuthor(book.getAuthor()); // Update author if needed

            // Save the updated book (JPA will check the version field)
            return bookRepo.save(existingBook);

        } catch (OptimisticLockingFailureException e) {
            // Handle the case where the book has been modified by another user
            throw new RuntimeException("The book was modified by another user. Please try again.");
        }
    }

    // Method to get all books
    public List<Books> getAllBooks() {
        return (List<Books>) bookRepo.findAll();
    }

    // Method to delete a book (by object)
    public void deleteBook(Books book) {
        bookRepo.delete(book);
    }

    // Method to delete a book by ID
    public void deleteBookById(int id) {
        bookRepo.deleteById(id);
    }
}
