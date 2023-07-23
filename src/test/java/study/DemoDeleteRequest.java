package study;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoDeleteRequest {

	@Test
	public void checkDelete() {
		
		Response resp = RestAssured.delete("http://localhost:3000/posts/3");
		
		// Fetch & Print Complete Response
		resp.then().log().all();
	}
}
