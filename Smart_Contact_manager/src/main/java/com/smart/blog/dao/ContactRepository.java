package com.smart.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.blog.entities.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer>{

	@Query("SELECT c FROM ContactEntity c WHERE LOWER(c.blogTitle) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<ContactEntity> searchByTitle(@Param("keyword") String keyword);
}
