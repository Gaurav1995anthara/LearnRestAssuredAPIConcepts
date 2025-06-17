package april_21st;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import april_21st.Complex.King;
import april_21st.Complex.Tagsk;
import april_21st.PetAPI.Category;
import april_21st.PetAPI.Tags;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class ComplexUsersList {

	@Test
	public static void alll() {
		RestAssured.baseURI = "https://fakestoreapi.com";
		
		
		Complex.Geo geo1 = new Complex.Geo("123","456");
		Complex.Address add1 = new Complex.Address("mang", "kar", geo1);
		List<String> photos1 = Arrays.asList("hello","hiii");
		Complex.Tagsk tags1 = new Complex.Tagsk(11, "gv1");
		Complex.Tagsk tags2 = new Complex.Tagsk(22, "gv2");
		List<Tagsk> alltags1 = Arrays.asList(tags1,tags2);
		Complex.King king1 = new Complex.King(33, "unni1");
		Complex.King king2 = new Complex.King(44, "unni2");
		List<King> allking = Arrays.asList(king1,king2);
		Complex.Category cat1 = new Complex.Category(allking, 777, "dksheb");
		
		Complex complexAll = new Complex(200, "suchet", cat1, photos1, alltags1, "active", add1, "varmaaa");
		
		Response response = given().log().all()
				.contentType(ContentType.JSON)
				.body(complexAll)
			.when().log().all()
				.post("/api/v3/pet");
			
			response.prettyPrint();
	}
}
