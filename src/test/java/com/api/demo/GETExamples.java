package com.api.demo;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class GETExamples {
	/*
	 * I've hosted a fake JSON server in localhost and pointing my get request to that server in this class
	 */
	@Test
	public void getAllPosts() {
		baseURI = "http://localhost:3000/";
		
		given().get("/posts").then().body("[0].title", equalTo("json-server")).statusCode(200).log().all();
	}
	

}
