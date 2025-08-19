package spec_builder;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

	public static RequestSpecification getRequest() {
		
		return new RequestSpecBuilder()
		.setBaseUri("")
		.setContentType(ContentType.JSON)
		.build();
		
	}
	
	
	public static ResponseSpecification getResponse() {
		
		return new ResponseSpecBuilder()
		.expectStatusCode(200)
		.build();
		
	}
}
