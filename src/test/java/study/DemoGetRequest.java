package study;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoGetRequest {

	@Test
	public void checkGet() {
		
		Response resp = RestAssured.get("http://localhost:3000/posts");
				
		String title = resp.jsonPath().get("[0].title");
		System.out.println(title);
		
		ArrayList lst = resp.jsonPath().get("title");
		System.out.println(lst);
		
		RestAssured.given()
					.when()
						.get("http://localhost:3000/posts")
					.then()
						.log().all();
	}
	
	@Test
	public void sample() {
		// hello "gaurav" welcome to class
		
		String s = "hello \"gaurav\" welcome to class";
		System.out.println(s);
	}
}





















