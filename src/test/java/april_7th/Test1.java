package april_7th;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class Test1 {

	@Test
	public static void learn1() {
		
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		given().log().all().header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2Y1ZTdkYTBhNmVjNDAwMTM0Y2FmNGUiLCJpYXQiOjE3NDQxNjg5MjJ9.x6eJKEWb-nXVxW0ma6yBT-bQfYOYHkbgKWx8IJXo_LE")
		.when().get("/contacts")
		.then().log().all()
		.assertThat()
		.statusCode(200);
	}
	
	
	@Test
	public static void learn2() {
		
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		String res = given().log().all().header("Authorization","Bearer-test")
		.when().get("/contacts")
		.then()
		.extract()
		.response()
		.path("error");
		
		System.out.println(res + "---------------------------------");
	}
}
