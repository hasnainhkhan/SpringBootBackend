package com.smart.contact.dao;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.smart.contact.entities.UserEntity;

@Repository 
public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
