package com.labs.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.dao.UserDao;
import com.labs.model.User;
import com.labs.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(int id) {
		for (User user: getAllUsers()) {
			if(id == user.getId())
				return user;
		}
		return null;
	}

	@Override
	public List<User>  getAllUsers() {
		List<User> userList = new ArrayList<User>();
//		userList.add(new User(1, "younes"));
//		userList.add(new User(2, "othmane"));
//		userList.add(new User(3, "yassine"));
		return userList;
	}

	@Override
	public void addUser(User user) {
		this.userDao.save(user);
	}
	
	
	

}
