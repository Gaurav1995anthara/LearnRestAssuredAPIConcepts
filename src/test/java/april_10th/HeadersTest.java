package april_10th;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HeadersTest {

	@Test
	public static void headertest() {
		
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		RequestSpecification req = RestAssured.given();
		
		req.header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2N2ZjYTlmMWMyNmEyYjAwMTUxMjI4MDQiLCJpYXQiOjE3NDQ2MTE4MjV9.Fql6e3iiQnifgTe4TaPiADTOlch0jzhYnvgTEF_FekI");
		Response response = req.get("/contacts");
		
		response.prettyPrint();
		response.statusCode();
		
	//	String rbody = response.body().asString();
		
		JsonPath jp = response.jsonPath();
		
		String ctype = response.header("content-type");
		
		Headers head = response.headers();
		
		for(Header i : head) {
			System.out.println(i.getName() + "--" + i.getValue());
		}
		
	}
}
