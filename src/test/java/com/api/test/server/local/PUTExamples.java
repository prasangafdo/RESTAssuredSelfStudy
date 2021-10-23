package com.api.test.server.local;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PUTExamples {
	
	@Test
	public void updatePost() {
		baseURI = "http://localhost:3000/";
		
		 Map<String, Object> map = new HashMap<String, Object>();
		 
		 	map.put("id", 4);
		 	map.put("title", "Sample title 0001 updated");
			map.put("author", "Test author updated");
			
			JSONObject jsonObject = new JSONObject(map);
			
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(jsonObject.toJSONString()).when().put("posts/4").then().log().all();
	}

}
