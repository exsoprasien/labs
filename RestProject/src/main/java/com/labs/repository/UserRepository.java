package com.labs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.labs.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long>, IUserRepository {
	//public interface UserRepository extends CrudRepository<User, Long> {

}