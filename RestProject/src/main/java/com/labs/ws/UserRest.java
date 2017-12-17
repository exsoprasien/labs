package com.labs.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.model.User;
import com.labs.service.UserService;

@RestController("/")
public class UserRest {

	@Autowired
	private UserService userService;
	

	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable("id") int id) {
		return this.userService.getUser(id);
	}
	
	@PostMapping("/users/add")
	public ResponseEntity  addUser(@RequestBody User user) {
		this.userService.addUser(user);
		return new ResponseEntity(user, HttpStatus.OK);
		
	}
	
	@RequestMapping("/users")
	public List<User> getUsers() {
		//return this.userService.getAllUsers();
		List<User> list= new ArrayList<User>();
		User user = new User();
		user.setFirstname("toto");
		
		User user2 = new User();
		user2.setFirstname("toto2");
		
		list.add(user);
		list.add(user2);
		return list;
	}

}
