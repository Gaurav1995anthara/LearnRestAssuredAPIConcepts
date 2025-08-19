package practice;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import practice.Info.Address;
import practice.Info.Category;
import practice.Info.Geo;
import practice.Info.Kingg;
import practice.Info.Tags;

public class FullClass {

	@Test
	public static void readAll() throws JsonMappingException, JsonProcessingException {
		
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		
		Geo geo1 = new Geo(20,30);
		Address add = new Address(geo1, "mangalore", "Karnataka"); //address
		Tags tag1 = new Tags(20,"raju");
		Tags tag2 = new Tags(30,"rangam");
		List<Tags> allTags = new ArrayList<Tags>();   //tags
		allTags.add(tag1);
		allTags.add(tag2);
		
		List<String> pho = new ArrayList<String>();  //photourls
		pho.add("ph1");
		pho.add("ph2");
		
		Kingg kk1 = new Kingg(11,"bkutan");
		Kingg kk2 = new Kingg(11,"bkutan");
		
		List<Kingg> allking = new ArrayList<Kingg>();  //kings
		allking.add(kk1);
		allking.add(kk2);
		
		Category ctg = new Category(allking, 99 , "manaraj"); // catag
		
		Info inf = new Info(3,"gv",ctg,pho,allTags,"active",add,"gaurav varma a");
		

		Response response = given().log().all().contentType(ContentType.JSON)
		.body(inf)
		.when()
		.post("/users")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.extract()
		.response();
		
		ObjectMapper mapper = new ObjectMapper();
		Info info = mapper.readValue(response.getBody().asString(), Info.class);
		
		Category cat = info.getCategory();
		cat.getId();
		cat.getName();
		List<Kingg> king = cat.getKing();
		for(Kingg k : king) {
			System.out.println(k.getId());
			System.out.println(k.getName());
		}
		
	}
}
