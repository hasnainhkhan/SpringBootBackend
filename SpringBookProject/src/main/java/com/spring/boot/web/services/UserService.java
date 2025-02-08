package com.spring.boot.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.web.dao.UserEntity;
import com.spring.boot.web.repository.UserRepo;

import lombok.ToString;

@Service
@ToString
public class UserService {

    private UserEntity userEntity;

    @Autowired
    private UserRepo userRepo;

    public UserEntity createUser(UserEntity userEntity) {
	UserEntity user = userRepo.save(userEntity);
	return user;
    }

    public List<UserEntity> getAllUser() {
	List<UserEntity> list = userRepo.findAll();
	return list;
    }

    public UserEntity updateUser(UserEntity userEntity) {
	return userRepo.save(userEntity);
    }

    public void deleteUserById(UserEntity userEntity) {
	userRepo.delete(userEntity);
    }

    public void deleteAll(UserEntity userEntity) {
	userRepo.deleteAll();
    }

}
