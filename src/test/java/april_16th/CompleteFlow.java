package april_16th;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CompleteFlow {

	int id;
	String emailID;
	User userreq;
	UserResponse userresponse;
	ObjectMapper mapper;
	Response response;
	
	public static String getemail() {
		return "gv1" + System.currentTimeMillis() + "@opentext.com";
	}

	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "https://gorest.co.in";	
	}
	@Test
	public void all() {

		// Post

		userreq = new User.UserBuilder().name("gaurav").email(getemail()).gender("male").status("active").build();
	//	RestAssured.baseURI = "https://gorest.co.in";
		response = given().log().all()
				.header("Authorization", "Bearer 461454795086f32ff2df4628b5a3fb1fec57d7a569dafe1621851de971565686")
			.contentType(ContentType.JSON).body(userreq).when().post("/public/v2/users").then().log().all().assertThat()
				.statusCode(201).extract().response();
	
		 mapper = new ObjectMapper();
		
			try {
				userresponse = mapper.readValue(response.body().asString(), UserResponse.class);
				id = userresponse.getId();
				emailID = userresponse.getEmail();
				Assert.assertEquals(userresponse.getName(), "gaurav");
				Assert.assertEquals(userresponse.getEmail(), emailID);
				Assert.assertEquals(userresponse.getGender(), "male");
				Assert.assertEquals(userresponse.getStatus(), "active");
				Assert.assertEquals(userresponse.getId(), id);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {	
				e.printStackTrace();
			}
		
			System.out.println("-----------------------------------------");
			
			
			//get
	//		RestAssured.baseURI = "https://gorest.co.in";
			response =  given().log().all()
					.header("Authorization", "Bearer 461454795086f32ff2df4628b5a3fb1fec57d7a569dafe1621851de971565686")
					.contentType(ContentType.JSON)
					.when()
					.get("/public/v2/users/"+id)
					.then()
					.log().all()
					.assertThat()
					.statusCode(200)
					.extract()
					.response();
			
			mapper = new ObjectMapper();
			
			try {
				userresponse = mapper.readValue(response.body().asString(), UserResponse.class);
				id = userresponse.getId();
				Assert.assertEquals(userresponse.getName(), "gaurav");
				Assert.assertEquals(userresponse.getEmail(), emailID);
				Assert.assertEquals(userresponse.getGender(), "male");
				Assert.assertEquals(userresponse.getStatus(), "active");
				Assert.assertEquals(userresponse.getId(), id);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {	
				e.printStackTrace();
			}
					
			System.out.println("-----------------------------------------");
			
			//put
		//	RestAssured.baseURI = "https://gorest.co.in";
			userreq.setName("gaurav varma a");
			userreq.setStatus("inactive");
			response = given().log().all()
					.header("Authorization", "Bearer 461454795086f32ff2df4628b5a3fb1fec57d7a569dafe1621851de971565686")
					.contentType(ContentType.JSON).body(userreq).when().put("/public/v2/users/"+id).then().log().all().assertThat()
					.statusCode(200)
					.extract()
					.response();
			
					mapper = new ObjectMapper();
					
					try {
						userresponse = mapper.readValue(response.body().asString(), UserResponse.class);
						id = userresponse.getId();
						Assert.assertEquals(userresponse.getName(), "gaurav varma a");
						Assert.assertEquals(userresponse.getEmail(), emailID);
						Assert.assertEquals(userresponse.getGender(), "male");
						Assert.assertEquals(userresponse.getStatus(), "inactive");
						Assert.assertEquals(userresponse.getId(), id);
					} catch (JsonMappingException e) {
						e.printStackTrace();
					} catch (JsonProcessingException e) {	
						e.printStackTrace();
					}
			
			System.out.println("-----------------------------------------");
			
			//get
			
	//		RestAssured.baseURI = "https://gorest.co.in";
			response =  given().log().all()
					.header("Authorization", "Bearer 461454795086f32ff2df4628b5a3fb1fec57d7a569dafe1621851de971565686")
					.contentType(ContentType.JSON)
					.when()
					.get("/public/v2/users/"+id)
					.then()
					.log().all()
					.assertThat()
					.statusCode(200)
					.extract()
					.response();
			
			mapper = new ObjectMapper();
			
			try {
				userresponse = mapper.readValue(response.body().asString(), UserResponse.class);
				id = userresponse.getId();
				Assert.assertEquals(userresponse.getName(), "gaurav varma a");
				Assert.assertEquals(userresponse.getEmail(), emailID);
				Assert.assertEquals(userresponse.getGender(), "male");
				Assert.assertEquals(userresponse.getStatus(), "inactive");
				Assert.assertEquals(userresponse.getId(), id);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {	
				e.printStackTrace();
			}
					
			System.out.println("-----------------------------------------");
			
			//delete
			
	//		RestAssured.baseURI = "https://gorest.co.in";
			 given().log().all()
					.header("Authorization", "Bearer 461454795086f32ff2df4628b5a3fb1fec57d7a569dafe1621851de971565686")
					.contentType(ContentType.JSON)
					.when()
					.delete("/public/v2/users/"+id)
					.then()
					.log().all()
					.assertThat()
					.statusCode(204);
			
		
	}
}
