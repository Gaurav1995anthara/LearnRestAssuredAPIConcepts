package practicesession;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TypesOfHeaders {

	
	@Test
	public void head() {
		
		RestAssured.given()
		.header("key","value");
	}
	
	@Test
	public void head1() {
		
		RestAssured.given()
		.headers("key","value","key1","value1");
	}
	
	@Test
	public void head2() {
		
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/xml");
		
		RestAssured.given()
		.headers(headers);
	}
	
	@Test
	public void head3() {
	
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer xyz");

		Headers headers = new Headers(h1, h2);

		RestAssured.given()
		.headers(headers);
	}
	
	
	public static void tesss() {
		
	Response response = null;
	// Get all headers
	Headers allHeaders = response.getHeaders();

	// Iterate over headers
	for (Header header : allHeaders) {
	    System.out.println(header.getName() + " : " + header.getValue());
	}

	// Get a specific header
	String contentType = response.getHeader("Content-Type");
	System.out.println("Content-Type: " + contentType);
	}
}

