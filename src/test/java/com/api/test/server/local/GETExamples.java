package com.api.test.server.local;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class GETExamples {
	/*
	 * I've hosted a fake JSON server in localhost and pointing my get request to that server in this class
	 */
//	@Test
	public void getAllPosts() {
		baseURI = "http://localhost:3000/";
		given().get("/posts").then().log().body();
	}

	public void extractPostsByTitle(String PostTitle) {
		baseURI = "http://localhost:3000/";
	//	given().get("/posts").then().body("[*].title", equalTo(PostTitle)).statusCode(200).log().all();
		given().get("/posts").then().body("*.[*].title", hasItems(PostTitle));
		
	}
	
	@Test
	public void getPostsByTitle() {
		String PostTitle = "Facebook post uploaded by Supun";
	this.extractPostsByTitle(PostTitle);
	}
	

}
