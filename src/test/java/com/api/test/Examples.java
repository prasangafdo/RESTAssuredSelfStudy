package com.api.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Examples {
	
	@Test
	public void sampleGet() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.asPrettyString());
	}

}
