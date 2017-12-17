package com.labs.service;

import java.util.List;

import com.labs.model.User;

public interface UserService {

	public User getUser(int id);

	public void addUser(User user);

	public List<User> getAllUsers();

}
