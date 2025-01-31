package com.spring.boot.web.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Books {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int bookId;
    private String bookTitle;
    private String bookAuthor;
}
