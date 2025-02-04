package com.spring.boot.web.Entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "books")
public class Books {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int bookId;
    private String bookTitle;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    
//    @jakarta.persistence.Version
//    private Integer version; 

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Books(int bookId, String bookTitle, Author author) {
	super();
	this.bookId = bookId;
	this.bookTitle = bookTitle;
	this.author = author;
    }

    public Books() {
	super();
	// TODO Auto-generated constructor stub
    }
    
}
