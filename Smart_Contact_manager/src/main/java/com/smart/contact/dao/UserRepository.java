package com.smart.contact.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smart.contact.entities.UserEntity;

@Repository 
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	//userEntity should be match with entity class name 
	@Query("select u from UserEntity u where u.email = :email")
	public UserEntity getUeserByUserName(@Param("email") String email);
}
