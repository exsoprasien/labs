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

	
}
