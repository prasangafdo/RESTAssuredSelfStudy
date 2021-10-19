package com.api.test.server.local;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class PATCHExamples {
	
	@SuppressWarnings("unchecked")
	@Test
	public void UpdatePostTitle() {
	baseURI = "http://localhost:3000/";
	
	//Change the post ID and value here
	int postID = 5;
	String value = "This is the patch request updated value";
	
	
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("title", value);
	
	given().
		contentType(ContentType.JSON).accept(ContentType.JSON).body(jsonObject.toJSONString()).
	when().
		patch("posts/"+postID).
	then().
		statusCode(200).log().body();
	
	}
	

}
