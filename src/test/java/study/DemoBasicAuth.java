package study;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DemoBasicAuth {

	@Test
	public void checkBasicAuth() {
		
		Response resp = given()
						.auth().basic("postman", "password")
						.get("https://postman-echo.com/basic-auth");
		
		resp.then().log().all();
	}
}
