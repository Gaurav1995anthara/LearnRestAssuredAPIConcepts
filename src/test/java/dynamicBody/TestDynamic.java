package dynamicBody;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestDynamic {

	@Test
	public void testdb() throws IOException {
		
		RestAssured.baseURI = "https://petstore3.swagger.io";
		
		Response response = given()
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
		.when().post("/api/v3/pet")
		.then()
		.assertThat()
		.statusCode(200)
		.extract().response();
		
		System.out.println("======================================="+response.prettyPrint());
		
		ObjectMapper mapper = new ObjectMapper();
	    JsonNode root = mapper.readTree(response.getBody().asString());
	    
		String name = root.get("name").asText();
		System.out.println("name: " + name);
		Assert.assertNotNull(name);
		Assert.assertTrue(name.matches("[a-zA-Z]+"));
		
		Iterator<Map.Entry<String, JsonNode>> fields = root.fields();
		while (fields.hasNext()) {
		    Map.Entry<String, JsonNode> entry = fields.next();
		    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue().asText());
		}
	}
}
