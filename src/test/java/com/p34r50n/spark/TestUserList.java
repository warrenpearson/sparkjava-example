package com.p34r50n.spark;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUserList {

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		List<String> expectedUsers = new ArrayList<String>();
		expectedUsers.add("Warren");
		expectedUsers.add("Natalie");
		
		List<String> actualUsers = null;
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create("http://127.0.0.1:4567/get_user_list"))
		      .build();
		
		HttpResponse<String> response;
		
		try {
			response = client.send(request, BodyHandlers.ofString());
			String jsonsUsers = response.body();
			actualUsers = new ObjectMapper().readValue(jsonsUsers, List.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	 	Assert.assertEquals("User list did not match", expectedUsers, actualUsers);
	}

}
