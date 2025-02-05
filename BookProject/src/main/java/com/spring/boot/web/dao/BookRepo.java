package com.spring.boot.web.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.spring.boot.web.Entities.Books;

public interface BookRepo extends CrudRepository<Books, Integer> {

    @Query("DELETE FROM Books b WHERE b.bookId = :id")
    void deleteByBookId(int id);
}
