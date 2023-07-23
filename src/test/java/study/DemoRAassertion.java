package study;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DemoRAassertion {

	@Test
	public void checkRAassertion() {
		
//		Response resp = given()
//				.param("id", "27")
//				.param("userId", "3")
//				.pathParam("x", "posts")
//			.when()
//				.get("https://jsonplaceholder.typicode.com/{x}");
//		
//		// status code
//		resp.then().assertThat().statusCode(200);
//		
//		// content type
//		resp.then().assertThat().contentType(ContentType.JSON);
//		
//		// response time
//		resp.then().assertThat().time(Matchers.lessThan(2000L));
//		
//		// response body
//		resp.then().assertThat().body("[0].userId", Matchers.equalTo(3));
//		resp.then().assertThat().body("[0].title", Matchers.equalTo("quasi id et eos tenetur aut quo autem"));
//		
//		resp.then().log().all();
		
		given()
			.param("id", "27")
			.param("userId", "3")
			.pathParam("x", "posts")
		.when()
			.get("https://jsonplaceholder.typicode.com/{x}")
		.then()
			.assertThat().statusCode(200).and()
			.contentType(ContentType.JSON).and()
			.time(Matchers.lessThan(2000L)).and()
			.body("[0].userId", Matchers.equalTo(3)).and()
			.body("[0].title", Matchers.equalTo("quasi id et eos tenetur aut quo autem")).and()
			.log().all();
	}
}














