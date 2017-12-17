package com.labs.dao;

import org.springframework.data.repository.CrudRepository;

import com.labs.model.User;

public interface UserDao extends CrudRepository<User, Long> {

}