package practicesession;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class FormParam {

	// Used for application/x-www-form-urlencoded requests, often in HTML form
	// submissions.

	// I use .formParam() when the API expects data in
	// application/x-www-form-urlencoded format — for example,
	// login APIs or OAuth token requests. It sends data as key-value pairs in the
	// request body, similar to how HTML forms work

	public void form() {
		RestAssured.given().contentType("application/x-www-form-urlencoded")
				.formParam("grant_type", "client_credentials").formParam("client_id", "abc123")
				.formParam("client_secret", "xyz789").when().post("/oauth2/token");
	}

	@Test
	public void fm() {

		RestAssured.given().contentType(ContentType.URLENC) // Or "application/x-www-form-urlencoded"
				.formParam("username", "testuser").formParam("password", "testpass").when().post("/login");
	}

	@Test
	public void fm2() {

		Map<String, String> formData = new HashMap<>();
		formData.put("grant_type", "client_credentials");
		formData.put("client_id", "my_client");

		RestAssured.given().contentType(ContentType.URLENC).formParams(formData).when().post("/oauth/token");
	}
	
	/*
	Don’t Confuse with .multiPart()
	
	Method Used	Content-Type Required?	Typical Use Case
	.formParam() only	   ✅ Yes (application/x-www-form-urlencoded)	   Login, token, form submits
	.multiPart()	       ❌ No (auto set to multipart/form-data)	       File uploads
	.body() (JSON)	       ✅ Yes (application/json)	API payloads
	
	*/
}
