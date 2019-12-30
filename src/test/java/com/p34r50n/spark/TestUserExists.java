package com.p34r50n.spark;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.junit.Assert;
import org.junit.Test;

public class TestUserExists {

	@Test
	public void test() {
		String expectedUser = "Warren";
		String actualUser = "";
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		      .uri(URI.create("http://127.0.0.1:4567/check_user_exists?user=" + expectedUser))
		      .build();
		
		HttpResponse<String> response;
		
		try {
			response = client.send(request, BodyHandlers.ofString());
			actualUser = response.body();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	 	Assert.assertEquals("User not found", expectedUser, actualUser);
	}

}
