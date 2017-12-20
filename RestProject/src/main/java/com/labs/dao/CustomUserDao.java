package com.labs.dao;

import com.labs.model.User;

import java.util.Optional;

public interface CustomUserDao {

    Optional<User> findByFirstname(String firstname);
}
