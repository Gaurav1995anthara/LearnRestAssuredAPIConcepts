package removePractice;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
public class HHamcrest {

	
	@Test
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

                // 🔹 Validate simple fields
                .body("id", equalTo(10))
                .body("name", equalTo("doggie"))
                .body("status", equalTo("available"))
                
                // 🔹 Validate arrays (photoUrls)
                .body("photoUrls", hasItems("hello", "hii")) // order doesn’t matter
                .body("photoUrls", hasSize(2))               // ensure exactly 2 items


                // 🔹 Validate nested object (category)
                .body("category.id", equalTo(1))
                .body("category.name", equalTo("Dogs"))

               
                // 🔹 Validate array of objects (tags)
                .body("tags.id", hasItems(1, 2))
                .body("tags.id", hasSize(2))
                .body("tags.name", hasItems("gv1", "gv2"))
                .body("tags.name", hasSize(2))

                // 🔹 Validate order specifically (if needed)
                .body("tags.id", contains(1, 2))  // strict order check
                .body("tags.name", contains("gv1", "gv2"));
        
        
        System.out.println("=======================================================");
        
        
        		//note -  for dynamic fields
        		// .body("id", notNullValue());
                //  .body("userId", matchesPattern("^[0-9a-fA-F-]{36}$"));
                // .body("id", greaterThan(0));
        		// .body("id", lesserThan(0));
        
        
   //     notNullValue() → Field must exist and not be null.

   //     matchesPattern(regex) → Field must follow a certain format (UUID, timestamp).

   //     greaterThan() / lessThan() → Field must be a valid numeric value.
        
        System.out.println("=======================================================");
        
        //note -  for array
     /*   
        {
        	  "photoUrls": [
        	    "hello",
        	    "hii"
        	  ]
        	}
      */
        
    //    .body("photoUrls", equalTo(Arrays.asList("hello", "hii")))

        // Check contains items
    //    .body("photoUrls", hasItems("hello", "hii"))

        // Check order doesn’t matter
     //   .body("photoUrls", containsInAnyOrder("hii", "hello"));
        
        
        System.out.println("=======================================================");
        
        //
     /*   
        {
        	  "address": {
        	    "city": "mangalore",
        	    "state": "kar"
        	  }
        	}
       */
        /*
         
        Map<String, String> expectedAddress = new HashMap<>();
        expectedAddress.put("city", "mangalore");
        expectedAddress.put("state", "kar");

        given()
        .when()
            .get("/pet/10")
        .then()
            .body("address", equalTo(expectedAddress));
            
         */   
    }
}
