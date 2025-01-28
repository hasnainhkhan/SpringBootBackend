package com.spring.boot.web.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Books {
	
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
}
