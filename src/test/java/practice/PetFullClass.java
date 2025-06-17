package practice;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import practice.PetRespo.Category;
import practice.PetRespo.Tags;
public class PetFullClass {
	
	@Test
	public static void readandwrite() throws JsonMappingException, JsonProcessingException {
		
		RestAssured.baseURI = "https://petstore3.swagger.io";
		
		Category catg = new Category(1,"gv1");  // category
		
		List<String> photo =  Arrays.asList("https://gv1", "https://gv2");  // photourl
		
		Tags tg1 = new Tags(2,"fk1");
		Tags tg2 = new Tags(3,"fk2");
		
		List<Tags> alltg = new ArrayList<Tags>();   // tags
		alltg.add(tg1);
		alltg.add(tg2);                          
		
		PetRespo petrepo = new PetRespo(33,"jk1",catg,photo,alltg,"active");
		
		Response response = given().log().all().contentType(ContentType.JSON)
		.body(petrepo)
		.when()
		.post("/api/v3/pet")
		.then().log().all()
		.statusCode(200)
		.extract()
		.response();
		
		ObjectMapper obj = new ObjectMapper();
		PetRespo ptRep = obj.readValue(response.getBody().asString(), PetRespo.class);
		
		System.out.println(ptRep.getId());
		System.out.println(ptRep.getName());
		System.out.println(ptRep.getStatus());
		Category ct = ptRep.getCategory();
		System.out.println(ct.getId());
		System.out.println(ct.getName());
		
		List<String> resphoto = ptRep.getPhotoUrls();
		
		for(String i : resphoto) {
			System.out.println(i);
		}
		
		List<Tags> tgs = ptRep.getTags();
		
		for(Tags j : tgs) {
			System.out.println(j.getId());
			System.out.println(j.getName());
		}
		
		
	}

}
