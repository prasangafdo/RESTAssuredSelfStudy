package com.api.test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class POSTExamples {

	@Test
	public void SamplePostUsingHashMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Prasanga");
		map.put("job", "Quality Engineer");
		System.out.println(map);
	}
	
}
