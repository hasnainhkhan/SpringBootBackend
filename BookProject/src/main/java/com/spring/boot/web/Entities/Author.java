package com.spring.boot.web.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
import lombok.Data;

@Entity @Data
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer a_id;
    private String a_name;
    private String a_lang;
    
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Books book;
    @Version // Hibernate uses this for optimistic locking
    private Integer version;
   
    
}
