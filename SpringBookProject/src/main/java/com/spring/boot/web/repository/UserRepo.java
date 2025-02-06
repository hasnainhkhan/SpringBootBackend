package com.spring.boot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.web.dao.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{

}
