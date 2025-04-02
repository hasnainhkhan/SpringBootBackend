package com.smart.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.blog.entities.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer>{

}
