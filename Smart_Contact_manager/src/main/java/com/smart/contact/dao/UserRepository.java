package com.smart.contact.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.smart.contact.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
