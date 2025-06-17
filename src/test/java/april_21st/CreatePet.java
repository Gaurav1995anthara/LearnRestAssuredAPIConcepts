package april_21st;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import april_21st.PetAPI.Category;
import april_21st.PetAPI.Tags;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreatePet {

	@Test
	public static void PostAlluser() throws JsonMappingException, JsonProcessingException {
	
	RestAssured.baseURI = "https://petstore3.swagger.io";
	
	/*
	Tags tags1 = new Tags(1, "gv1");
	Tags tags2 = new Tags(2, "gv2");
	
	List<Tags> tags = Arrays.asList(tags1,tags2);
	
	List<String> photoUrls = Arrays.asList("https://ex.com", "https://dog.com");
	
	PetAPI.Category category = new PetAPI.Category(1, "Dogs");
	
	PetAPI petapi = new PetAPI(1, "unni", "active", category, photoUrls, tags);
	
	Response response = given().log().all()
			.contentType(ContentType.JSON)
			.body(petapi)
		.when().log().all()
			.post("/api/v3/pet");
		
		response.prettyPrint();
	
	

	*/
	
	Tags tags1 = new Tags();
	tags1.setId(1);
	tags1.setName("kaka");
	
	Tags tags2 = new Tags();
	tags2.setId(1);
	tags2.setName("lala");
	
	List<Tags> tg = Arrays.asList(tags1,tags2);
	
	ArrayList ar = new ArrayList<>();
	ar.add("https://ex.com");
	ar.add("https://eda1.com");
	
	
	Category ct = new Category();
	ct.setId(2);
	ct.setName("ppdpdp");
	
	PetAPI pp = new PetAPI();
	pp.setId(22);
	pp.setName("sham");
	pp.setStatus("activee");
	pp.setPhotoUrls(ar);
	pp.setCategory(ct);
	pp.setTags(tg);
	
	
	Response response = given().log().all()
			.contentType(ContentType.JSON)
			.body(pp)
		.when().log().all()
			.post("/api/v3/pet");
		
		response.prettyPrint();
		
		ObjectMapper mapper = new ObjectMapper();
		
		
			PetAPI petRes = mapper.readValue(response.getBody().asString(), PetAPI.class);
			
			System.out.println(petRes.getId());
			System.out.println(petRes.getName());
			System.out.println(petRes.getStatus());
			
			Category category = petRes.getCategory();
			System.out.println(category.getId());
			System.out.println(category.getName());
			
			List<String> photos = petRes.getPhotoUrls();
			for(String i : photos) {
				System.out.println(i);
			}
			
			List<Tags> ttt = petRes.getTags();
			
			for(Tags j : ttt) {	
				System.out.println(j.getId());
				System.out.println(j.getName());
			}
			
	}
}
