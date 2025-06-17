package april_9th;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class QueryParam {

	@Test
	public void query() {
		
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		given().log().all()
		.when().get("/products").then().log().all()
		.assertThat()
		.statusCode(200)
		.and()
		.body("$.size()", equalTo(20))
		.body("title", hasItem("Mens Casual Premium Slim Fit T-Shirts "));
		
	}
	
	
	
	@Test
	public void query1() {
		
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		Response res = given().log().all()
		.when().get("/products").then().log().all()
		.extract().response();
		
		JsonPath jp = res.jsonPath();
		int ids = jp.getInt("id[0]");
		System.out.println(ids + "=============================================================");
		
		Object rate = jp.get("rating[3].rate");
		System.out.println(rate + "=============================================================");
		
		List<String> alltitle  = jp.getList("title");
		System.out.println(alltitle + "$$$$$$$$$");
		
		
		for(int i=0; i<alltitle.size(); i++) {
			
			if(alltitle.get(i).equalsIgnoreCase("White Gold Plated Princes")) {
				int count = jp.get("rating[i].count");
				Assert.assertEquals(count, 400);
			}
		}
		
	}	
	
	/*
	
		@Test
		public void query2() {
			
			RestAssured.baseURI = "https://fakestoreapi.com";
			
			String res = given().log().all()
			.when().get("/products").then().log().all()
			.extract().response().body().asString();
			
			res.
			
			JsonPath jp = res.jsonPath();
			int ids = jp.getInt("id[0]");
			System.out.println(ids + "=============================================================");
			
			}
		*/	
	
}
