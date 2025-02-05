package com.spring.boot.web.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;

    @Column(name = "OPTLOCK")
    @Version // Hibernate will check version before updating
    private Integer version;
}
