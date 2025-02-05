package com.spring.boot.web.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer a_id;

    private String a_name;
    private String a_lang;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Books book;

    @Version
    @Column(name = "OPTLOCK") // Hibernate uses this for optimistic locking
    private Integer version;
}
