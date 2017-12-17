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
	public User getUser(@PathVariable("id") String id) {
		return this.userService.getUser(id);
	}

	@PostMapping("/users/add")
	public ResponseEntity addUser(@RequestBody User user) {
		this.userService.addUser(user);
		return new ResponseEntity(user, HttpStatus.OK);

	}

	@RequestMapping("/users")
	public List<User> getUsers() {
		return this.userService.getAllUsers();
	}

}
