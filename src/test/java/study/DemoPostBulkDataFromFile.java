package study;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DemoPostBulkDataFromFile {

	@Test
	public void insertData() throws IOException {
		
		File jsonFile = new File("./payloadCountry.json");
		
		FileInputStream fis = new FileInputStream(jsonFile);
		
		String jsonData = IOUtils.toString(fis , "UTF-8");
		
		given()
			.body(jsonData).contentType(ContentType.JSON)
		.when()
			.post("http://localhost:3000/posts")
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}
}
