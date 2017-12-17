package com.labs.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.labs.model.User;

public interface UserDao extends MongoRepository<User, Long> {
	//public interface UserDao extends CrudRepository<User, Long> {

}