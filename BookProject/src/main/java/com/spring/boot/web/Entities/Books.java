package com.spring.boot.web.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int bookId;

    private String bookTitle;

   
    private String author;

}
