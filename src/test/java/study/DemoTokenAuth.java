package study;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DemoTokenAuth {

	@Test
	public void checkTokenAuth() {
		
		// get the token
		Response resp1 = given()
							.param("client_id", "OAR")
							.param("client_secret", "c024123bfbf47efc2cdfdafae2d3693f")
							.param("grant_type", "client_credentials")
						.when()
							.post("http://coop.apps.symfonycasts.com/token");
		
		String token = resp1.jsonPath().get("access_token");
		System.out.println("token is : " + token);
		System.out.println("-------------------------------------------");
		
		// send request to actual api along with token
		Response resp = given()
				.auth().oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/1301/eggs-count");

		resp.then().log().all();
	}
}

