package DesrializationWithJSONArrayResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DesrializationWithJSONArrayResponse.Products.Rating;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProducts {

	@Test
	public void getAllProductsAPITest() {
		RestAssured.baseURI = "https://fakestoreapi.com";

		Response response = given()
				.when()
				.get("/products");

		response.prettyPrint();

		// Deserilization: json array to pojo
		ObjectMapper mapper = new ObjectMapper();
		try {
			Products[] product = mapper.readValue(response.getBody().asString(), Products[].class);
			
			for (Products p : product) {
				System.out.println("id: " + p.getId());
				System.out.println("title: " + p.getTitle());
				System.out.println("price: " + p.getPrice());
				System.out.println("description: " + p.getDescription());
				System.out.println("image: " + p.getImage());
				System.out.println("category: " + p.getCategory());

				Rating rating = p.getRating();
				System.out.println(rating.getRate());
				System.out.println(rating.getCount());

				System.out.println("rate: " + p.getRating().getRate());
				System.out.println("count: " + p.getRating().getCount());

			}

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
