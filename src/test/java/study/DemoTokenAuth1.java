package study;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import genericUtil.AuthenticationDetails;
import io.restassured.response.Response;

public class DemoTokenAuth1 {

	@Test
	public void checkTokenAuth() {
		
		// send request to actual api along with token
		String token = getToken();
		Response resp = given()
				.auth().oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/1301/eggs-count");

		resp.then().log().all();
	}
	
	public String getToken() {
		
		Response resp1 = given()
				.param("client_id", AuthenticationDetails.CLIENTID)
				.param("client_secret", AuthenticationDetails.CLIENTSECRET)
				.param("grant_type", AuthenticationDetails.GRANTTYPE)
			.when()
				.post("http://coop.apps.symfonycasts.com/token");

		String token = resp1.jsonPath().get("access_token");
		System.out.println("token is : " + token);
		System.out.println("-------------------------------------------");
		return token ;
	}
}













