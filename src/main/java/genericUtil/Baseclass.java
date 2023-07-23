package genericUtil;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class Baseclass {

	@BeforeSuite
	public void configBeforeSuite() {
		
		System.out.println("Configuration of domain name");
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
	//	RestAssured.basePath = ""; Here we can provide common resource path
	}
}
