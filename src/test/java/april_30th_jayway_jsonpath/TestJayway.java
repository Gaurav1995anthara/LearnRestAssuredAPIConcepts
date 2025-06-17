package april_30th_jayway_jsonpath;
import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import io.restassured.RestAssured;
public class TestJayway {

	@Test
	public static void jway() {
		
		RestAssured.baseURI = "https://fakestoreapi.com";
		String response =  given().when().get("/products").then().extract().response().asString();
		
		ReadContext c = JsonPath.parse(response);
		
		List<Map<String,Object>> idTitle = c.read("$.[*].['id','title']");
		
		for(Map<String,Object> i : idTitle) {
			
			System.out.println(i.get("id"));
			System.out.println(i.get("title"));
		}
		
		
		
		
		
	}
}
