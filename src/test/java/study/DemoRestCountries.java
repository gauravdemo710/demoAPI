package study;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoRestCountries {

	@Test
	public void checkCountries() {
		
		Response resp = RestAssured.get("https://restcountries.com/v3.1/all");
		
		String name = resp.jsonPath().get("name.common[170]"); 
		
		System.out.println(name);
		
		ArrayList lst = resp.jsonPath().get("currencies.BBD.symbol");
		System.out.println(lst);
	}
}
