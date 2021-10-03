package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GETExamples {
	
	@Test
	public void sampleGet() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Header >>>>>"+response.getHeader("content-type"));
	}
	
	@Test
	public void sampleGetInGherkins() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200);
		System.out.println(">>>>> This will get the response using BDD style");
		System.out.println(get("/users?page=3").getBody().asString());
	}
	
	@Test
	public void sampleGetWithRestAssuredAssertion() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			body("data[0].first_name", equalTo("Michael")). //Expecting exact value
			body("data.first_name", hasItems("Lindsay", "Tobias")). //Expecting these values contains in the response
			statusCode(200).
			log().all();//This will print all the data on the response
			
		
	}
	


}
	