package removePractice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Hamcrustt {

	@Test(enabled=false)
    public void validateJsonResponse() {
        RestAssured.baseURI = "https://petstore3.swagger.io/";

        given()
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
                .statusCode(200)
                .body("id", notNullValue())
                .body("id", lessThan(100))
                .body("id", equalTo(10))
                .body("id", instanceOf(Integer.class))
                .body("id", either(equalTo(10)).or(equalTo(11)))
                
                .body("name", equalTo("doggie"))
                .body("name", notNullValue())
                .body("name", equalToIgnoringCase("doggie"))
                
				.body("photoUrls", equalTo(Arrays.asList("hello", "hii")))
				.body("photoUrls", hasItems("hello","hii"))
				.body("photoUrls", contains("hello","hii"))
				.body("photoUrls", hasSize(2))
				.body("photoUrls", containsInAnyOrder("hii", "hello"))
				
				.body("tags.id", hasItems(1,2))
				.body("tags.name", hasItems("gv1","gv2"))
				
				.body("category", hasEntry("id", 1))
        		.body("category", hasEntry("name", "Dogs"))
      
        		.body("tags", hasItems(
        		        allOf(
        		            (Matcher) hasEntry("id", 1),
        		            (Matcher) hasEntry("name", "gv1")
        		        ),
        		        allOf(
        		            (Matcher) hasEntry("id", 2),
        		            (Matcher) hasEntry("name", "gv2")
        		        )
        		));
        		
	}        
        
        // Using JSON PATH
        
        @Test
        public void validateJsonResponseUsingJSONPATH() {
            RestAssured.baseURI = "https://petstore3.swagger.io/";

           Response res =  given()
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
                    .statusCode(200)
                    .extract()
                    .response();
           
           
           JsonPath js = res.jsonPath();
           int id = js.getInt("id");
           Assert.assertEquals(id, 10);
           
           List<String> expected = js.get("photoUrls"); 
           List<String> actual = new ArrayList<String>();
           actual.add("hello");
           actual.add("hii");
           Assert.assertEquals(actual, expected);
           
           List<Map<Integer,String>> exp = js.get("tags");
           LinkedHashMap<String,Object> ac1 = new LinkedHashMap<String,Object>();
           ac1.put("id", 1);
           ac1.put("name", "gv1");
           LinkedHashMap<String,Object> ac2 = new LinkedHashMap<String,Object>();
           ac2.put("id", 2);
           ac2.put("name", "gv2");
           List<Map<String,Object>> act = new ArrayList<>();
           act.add(ac1);
           act.add(ac2);
           Assert.assertEquals(exp, act);
           
           
      //     JSONAssert.assertEquals(jsonexpected, jsonActual, false); // strict = true → order and all fields must match  // strict = false → only values present in expected are checked, order doesn't matter
           
        }
	
             
}