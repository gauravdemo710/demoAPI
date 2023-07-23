package study;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DemoAssertions {

	@Test
	public void checkTestNGAssertion() {
		
		Response resp = given()
							.param("id", "27")
							.param("userId", "3")
							.pathParam("x", "posts")
						.when()
							.get("https://jsonplaceholder.typicode.com/{x}");
		
		// status code validation 
		int statusCode = resp.statusCode();
		Assert.assertEquals(statusCode, 200);
		
		// content type validation
		String contentType = resp.contentType();
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
		// response time
		long respTime = resp.time();
		System.out.println(respTime);
		Assert.assertTrue(respTime < 3000);
		
		// body validation
		Integer userId = resp.jsonPath().get("[0].userId");
		Assert.assertEquals(userId, 3);
		
		String title = resp.jsonPath().get("[0].title");
		Assert.assertEquals(title, "quasi id et eos tenetur aut quo autem");
		
		resp.then().log().all();
		
	}
}










