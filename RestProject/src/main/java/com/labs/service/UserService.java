package com.labs.service;

import java.util.List;

import com.labs.model.User;

public interface UserService {

	//For mysql
	//public User getUser(int id);
	public User getUser(String id);

	public User getUserByFirstname(String name);

	public void addUser(User user);

	public List<User> getAllUsers();

}
