package april_15th;

import java.io.IOException;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import april_15th.Pojos.PojosBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Serilization {

	public static String getemail() {
		
		return "gv"+System.currentTimeMillis()+"@opentext.com";
	}
	@Test
	public static void bodysS() throws IOException {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
	//	Pojos pj = new Pojos(DEFAULT_URI, DEFAULT_SESSION_ID_VALUE, DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH)
		
		Pojos pj = new Pojos.PojosBuilder()
				.name("gvss")
				.email(getemail())
				.gender("male")
				.status("active").build();
		
		given()
		.header("Authorization","Bearer 461454795086f32ff2df4628b5a3fb1fec57d7a569dafe1621851de971565686")
		.contentType(ContentType.JSON)
		.body(pj)
		.when()
		.post("/public/v2/users")
		.then()
		.assertThat()
		.statusCode(201);
		
	}
}
