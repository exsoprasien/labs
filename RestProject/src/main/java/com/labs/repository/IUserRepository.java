package com.labs.repository;

import com.labs.model.User;

import java.util.Optional;

public interface IUserRepository {

    Optional<User> findByFirstname(String firstname);
}
