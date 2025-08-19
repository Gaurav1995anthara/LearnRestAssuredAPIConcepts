package removePractice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Limit {

	int maxtries = 5;
	int delay = 1000;
	
	public class Hamcrustt {

		@Test(enabled=false)
	    public void validateJsonResponse() throws InterruptedException {
	        RestAssured.baseURI = "https://petstore3.swagger.io/";

	        Response res = given()
	        	.contentType(ContentType.JSON)
	        	.body("{\r\n"
	        			+ "    \"id\": 10,\r\n"
	        			+ "    \"name\": \"doggie\",\r\n"
	        			+ "    \"category\": {\r\n"
	        			+ "        \"id\": 1,\r\n"
	        			+ "        \"name\": \"Dogs\"\r\n"
	        			+ "    },\r\n"
	        			+ "    \"photoUrls\": [\r\n"
	        			+ "        \"hello\",\r\n"
	        			+ "        \"hii\"\r\n"
	        			+ "    ],\r\n"
	        			+ "    \"tags\": [\r\n"
	        			+ "        {\r\n"
	        			+ "            \"id\": 1,\r\n"
	        			+ "            \"name\": \"gv1\"\r\n"
	        			+ "        },\r\n"
	        			+ "        {\r\n"
	        			+ "            \"id\": 2,\r\n"
	        			+ "            \"name\": \"gv2\"\r\n"
	        			+ "        }\r\n"
	        			+ "    ],\r\n"
	        			+ "    \"status\": \"available\"\r\n"
	        			+ "}")
	            .when()
	                .post("api/v3/pet")
	            .then()
	                .extract()
	                .response();
	        
	        for(int i=0; i<maxtries; i++) {
	        	
	        	if(res.statusCode() == 200) {
	        		System.out.println("successfull");
	        		break;
	        	}else if(res.statusCode() == 429) {
	        		
	        		Thread.sleep(delay);
	        		delay = delay * 2;
	        		
	        	}else {
	        		
	        		int statuscode = res.statusCode();
	        	}
	        }
		}
		}
}
