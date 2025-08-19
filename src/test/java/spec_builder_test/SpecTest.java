package spec_builder_test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import spec_builder.SpecBuilder;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class SpecTest {

	@Test
	public void testing() {
		
		Response response = given().spec(SpecBuilder.getRequest())
		.when()
		.post("")
		.then()
		.spec(SpecBuilder.getResponse())
		.extract().response();
	}
}
