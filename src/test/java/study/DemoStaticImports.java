package study;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DemoStaticImports {

	@Test
	public void checkImports() {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("title", "Automation Title");
		map.put("auhtor", "automation Author");
		
		given().body(map).contentType(ContentType.JSON)
		.when().post("http://localhost:3000/posts")
		.then().log().all();
	}
}
