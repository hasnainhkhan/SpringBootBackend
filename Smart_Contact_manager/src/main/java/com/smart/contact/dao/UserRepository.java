package com.smart.contact.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.contact.entities.UserEntity;

@Repository 
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
