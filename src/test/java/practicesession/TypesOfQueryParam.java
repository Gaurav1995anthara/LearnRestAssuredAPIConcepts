package practicesession;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TypesOfQueryParam {

	@Test
	public void param() {
		
		RestAssured.given()
		.queryParam("id", 2)
		.queryParam("name", "ram");
	}
	
	@Test
	public void param1() {
		
		Map<String, Object> queryParams = new HashMap<>();
		
		queryParams.put("page", 2);
		queryParams.put("sort", "asc");

		RestAssured.given()
		.queryParams(queryParams);
	}
	
	@Test
	public void param2() {
		
		RestAssured.given()
		.queryParams("id", 2, "sort", "asc")
		 .queryParam("ids", 1, 2, 3); // Becomes ?ids=1&ids=2&ids=3
	}
	
	@Test
	public void param3() {
		
		RestAssured.given()
		.queryParams("id", 2, "sort", "asc");
	}
}
