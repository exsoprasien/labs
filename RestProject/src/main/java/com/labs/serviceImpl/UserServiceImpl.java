package com.labs.serviceImpl;

import java.util.List;

import com.labs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.model.User;
import com.labs.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	//for Mysql
//	@Override
//	public User getUser(int id) {
//		for (User user: getAllUsers()) {
//			if(id == user.getId())
//				return user;
//		}
//		return null;
//	}
	
	@Override
	public User getUser(String id) {
		for (User user: getAllUsers()) {
			if(id.equals(user.getId()))
				return user;
		}
		return null;
	}

	@Override
	public User getUserByFirstname(String firstname) {
		return userRepository.findByFirstname(firstname).orElse(null);
	}


	@Override
	public List<User>  getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public void addUser(User user) {
		this.userRepository.save(user);
	}
	
	
	

}
