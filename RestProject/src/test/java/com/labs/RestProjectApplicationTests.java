package com.labs;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.labs.model.User;
import com.labs.model.UserVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestProjectApplicationTests {
	
	private final static String URL="http://localhost:8080/users/5a36ef24617b6b0fd47e1fd1";

	@Test
	public void contextLoads() throws JsonParseException, JsonMappingException, IOException {
		
		RestTemplate restTemplate= new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> entity = new HttpEntity<User>(headers);
		ResponseEntity<String> response = restTemplate
				  .exchange(URL, HttpMethod.POST, entity, String.class);
		System.out.println(getUserObject(response.getBody()));
	}
	
	public UserVo getUserObject(String response) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper =  new ObjectMapper();
		return mapper.readValue(response, UserVo.class);
	}

}
