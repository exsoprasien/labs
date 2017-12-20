package com.labs.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.labs.model.User;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

public interface UserDao extends MongoRepository<User, Long>, CustomUserDao {
	//public interface UserDao extends CrudRepository<User, Long> {

}