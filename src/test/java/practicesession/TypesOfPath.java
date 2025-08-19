package practicesession;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TypesOfPath {

	@Test
	public void path() {
		
		RestAssured.given()
		.pathParam("ids", 2)
		.pathParam("names", "ram")
		.when()
		.get("id/{ids}/name/{names}");
		
		
	}
	
	@Test
	public void path1() {
		
		Map<String, Object> pathVars = new HashMap<>();
		pathVars.put("category", "electronics");
		pathVars.put("productId", 789);

		RestAssured.given()
		    .pathParams(pathVars)
		.when()
		    .get("/api/{category}/products/{productId}");
		
		
	}
	
	@Test
	public void path2() {
		
		RestAssured.given()
	    .pathParams("userId", 101, "postId", 202)
	    .when()
	        .get("/users/{userId}/posts/{postId}");
		
		
	}
}
