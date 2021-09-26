package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Examples {
	
	@Test
	public void sampleGet() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test
	public void sampleGet2() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200);
		System.out.println(get("/users?page=3").getBody().asString());
	}
	

}
	