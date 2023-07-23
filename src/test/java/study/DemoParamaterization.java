package study;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class DemoParamaterization {

	@Test
	public void checkParameter() {
		
		given()
			.param("id", "27")
			.param("userId", "3")
			.pathParam("x", "posts")
		.when()
			.get("https://jsonplaceholder.typicode.com/{x}")
		.then()
			.log().all();
	}
}
