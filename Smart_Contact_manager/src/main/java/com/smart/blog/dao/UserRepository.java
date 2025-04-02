package com.smart.blog.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smart.blog.entities.UserEntity;

@Repository 
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	//userEntity should be match with entity class name 
	@Query("select u from UserEntity u where u.email = :email")
	public UserEntity getUeserByUserName(@Param("email") String email);
	
	// search by name and email
	List<UserEntity> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);

	Optional<UserEntity> findByEmail(String email);
}
