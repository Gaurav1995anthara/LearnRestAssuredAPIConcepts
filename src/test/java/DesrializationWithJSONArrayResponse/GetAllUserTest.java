package DesrializationWithJSONArrayResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllUserTest {

	@Test
	public static void getallusers() throws JsonMappingException, JsonProcessingException {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		Response res = given().log().all()
		.when()
		.get("/public/v2/users")
		.then().log().all()
		.extract()
		.response();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		User[] usr = objectMapper.readValue(res.body().asString(), User[].class);
		
		for(User i :usr) {
			
			System.out.println(i.getId());
			System.out.println(i.getEmail());
		}
	}
}
