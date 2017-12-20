package com.labs.ws;

import java.util.List;

import com.labs.validator.UserValidation;
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

	@Autowired
	private UserValidation userValidation;

	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable("id") String id) {
		return this.userService.getUser(id);
	}

	@RequestMapping("/users/byfirstname/{firstname}")
	public User getUserByName(@PathVariable("firstname") String firstname) {
		return this.userService.getUserByFirstname(firstname);
	}

	@PostMapping("/users/add")
	public ResponseEntity addUser(@RequestBody User user) {
		userValidation.validateUser(user);
		this.userService.addUser(user);
		return new ResponseEntity(user, HttpStatus.OK);

	}

	@RequestMapping("/users")
	public List<User> getUsers() {
		return this.userService.getAllUsers();
	}
}
