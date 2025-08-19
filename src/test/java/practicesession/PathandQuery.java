package practicesession;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import spec_builder.SpecBuilder;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;


public class PathandQuery {
	
	@Test
	public void test1() {
		
	//GET https://api.example.com/users/gaurav/orders/varma
		
		HashMap<String,String> hmpath = new HashMap<String,String>();
		hmpath.put("userid", "gaurav");
		hmpath.put("orderid", "varma");
		
		HashMap<String,String> hmQueryh = new HashMap<String,String>();
		hmpath.put("id", "10");
		hmpath.put("lastname", "varma");
		
		given().baseUri("")
		.pathParams(hmpath)
		.queryParams(hmQueryh)
		.when()
		.get("/users/{userid}/orders/{orderid}");
	}
}
