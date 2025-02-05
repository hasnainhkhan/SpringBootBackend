package com.spring.boot.web.Entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;


@Entity
@Table(name = "books")
public class Books {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int bookId;
    private String bookTitle;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;
    
    @Version  // Hibernate will check version before updating
    private Integer version;
    
    


//    @jakarta.persistence.Version
//    private Integer version; 

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

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

 

    public Books(int bookId, String bookTitle, Author author, Integer version) {
	super();
	this.bookId = bookId;
	this.bookTitle = bookTitle;
	this.author = author;
	this.version = version;
    }

    public Books() {
	super();
	// TODO Auto-generated constructor stub
    }
    
}
