package removePractice;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestAndResponseSPECbuilder {

	static RequestSpecification req;
	static ResponseSpecification rep;
	
	@BeforeMethod
	public static void setup() {
		
		req = new RequestSpecBuilder()
				.setBaseUri("")
				.setContentType(ContentType.JSON)
				.addPathParam("", "")
				.build();
		
		rep = new ResponseSpecBuilder()
		.expectStatusCode(200)
		.expectStatusLine("")
		.build();
			
				
	}
	
	
	@Test
	public static void testing() {
		
		RestAssured.given().spec(req)
		.when()
		.get("")
		.then()
		.spec(rep);
	}
}
