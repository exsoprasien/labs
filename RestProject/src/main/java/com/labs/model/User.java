package com.labs.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity(name = "USER")
@Document(collection = "USERLAB")
public class User {

	
	
	@Id
	//This is for MySql
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private Integer id;
	private String id;
	private String firstname;
	private String lastname;
	private Date birthdate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

}
