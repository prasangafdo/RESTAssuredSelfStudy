package com.api.demo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class POSTExamples {
	
	@Test
	public void createNewPost() {
		Map <String, Object> map = new HashMap<String, Object>();
	//	map.put("id", 7);
		map.put("title", "Sample title 0001");
		map.put("author", "Test author");
			
		JSONObject json = new JSONObject(map);
		System.out.println("JSON formatted object");
		System.out.println(json);
		baseURI = "http://localhost:3000";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(json.toJSONString()).when().post("/posts").then().log().body();
	}
	
	

}
