package com.labs.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserVo {
	
	@JsonCreator
	public UserVo(@JsonProperty("id") String id, @JsonProperty("firstname") String firstName,
			@JsonProperty("lastname") String name, @JsonProperty("birthdate") Date birthdate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.birthdate = birthdate;
		this.name = name;
	}

	private String id;
	private String firstName;
	private String name;
	private Date birthdate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	
}
