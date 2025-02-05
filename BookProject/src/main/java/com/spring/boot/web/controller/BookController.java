package com.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.boot.web.Entities.Books;
import com.spring.boot.web.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/allbooks")  // Optional: Base URL for all book-related endpoints
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Books>> getBooks() {
        List<Books> list = bookService.getAllBooks();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);  // Simplified: no need for Optional
    }

    @PostMapping
    public ResponseEntity<Books> addBook(@RequestBody Books book) {
        try {
            Books addedBook = this.bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);  // Created status for successful creation
        } catch (OptimisticLockingFailureException e) {
            // Return response with Conflict status and error message in a response body
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(null);  // ResponseEntity for error with no body (or you can add error message inside a custom object)
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBook(@RequestBody Books book) {
        try {
            this.bookService.deleteBook(book);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // Proper 204 for successful deletion
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") int id) {
        try {
            this.bookService.deleteBookById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@RequestBody Books book, @PathVariable("id") int id) {
        try {
            this.bookService.updateBook(book, id);
            return ResponseEntity.status(HttpStatus.OK).build();  // 200 OK for successful update
        } catch (OptimisticLockingFailureException e) {
            // Handle optimistic locking failure and return a Conflict response
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(null);  // Or you can return a custom error object
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
