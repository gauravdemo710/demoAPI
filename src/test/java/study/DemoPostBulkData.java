package study;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DemoPostBulkData {

	@Test
	public void insertData() {
		
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		
		map2.put("Java", "1*");
		map2.put("Selenium", "2*");
		map2.put("Api", "3*");
		
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		
		map1.put("name", "Abhishek");
		map1.put("gender", "male");
		map1.put("address", "whitefield");
		map1.put("skills", map2);
		
		given()
			.body(map1).contentType(ContentType.JSON)
		.when()
			.post("http://localhost:3000/posts")
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}
}






















