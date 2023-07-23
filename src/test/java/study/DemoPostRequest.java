package study;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoPostRequest {

	@Test
	public void checkPost() {
		
		// For POST request we required HTTP Method, URI, Content type, Payload
		
		// step 1 :- set the payload
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("title", "Automation Title");
		map.put("auhtor", "automation Author");
		
//		RequestSpecification req = RestAssured.given();  // to set precondition for request.
//		req.body(map);
//		
//		// step 2 :- set content type
//		req.contentType(ContentType.JSON);
//		
//		// step 3 :- send request
//		Response resp = req.post("http://localhost:3000/posts");
//		
//		resp.then().log().all();
		
		RestAssured.given()
						.body(map)
						.contentType(ContentType.JSON)
					.when()
						.post("http://localhost:3000/posts")
					.then()
						.log().all();
	}
}










