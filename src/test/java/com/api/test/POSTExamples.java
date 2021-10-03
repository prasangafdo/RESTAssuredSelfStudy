package com.api.test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class POSTExamples {

	@Test
	public void SamplePostUsingHashMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Prasanga");
		map.put("job", "Quality Engineer");
		
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		System.out.println("JSON formatted object");
		System.out.println(request);
		System.out.println("Verifying the JSON formatted Object");
		System.out.println(request.toJSONString());
		
		
		System.out.println(">>> API Response");
		baseURI = "https://reqres.in/api";
		given().
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
	}
	
}
