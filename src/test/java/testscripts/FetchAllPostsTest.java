package testscripts;

import org.testng.annotations.Test;

import genericUtil.APIEndPoints;
import genericUtil.Baseclass;
import static io.restassured.RestAssured.*;

public class FetchAllPostsTest extends Baseclass{

	@Test
	public void fetchAllPosts() {
		
		given()
			.param("id", "27")
			.param("userId", "3")
		.when()
			.get(APIEndPoints.postsAPIEndPoint)
		.then()
			.log().all();
	}
}
