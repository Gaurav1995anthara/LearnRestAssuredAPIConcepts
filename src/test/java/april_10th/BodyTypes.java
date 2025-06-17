package april_10th;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class BodyTypes {

	public static String getemail() {
		
		return "gv"+System.currentTimeMillis()+"@opentext.com";
	}
	@Test
	public static void bodysS() throws IOException {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		String emailid = getemail();
		
		String jsoncon = new String(Files.readAllBytes(Paths.get("./src/test/java/april_10th/user.json")));
		String rbody = jsoncon.replace("{{email}}", emailid);
		
	}
	
}
