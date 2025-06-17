package april_28th_xml;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FormulaOneAPITest {

	@Test
	public void getFormulaOneTest() throws JsonMappingException, JsonProcessingException {
		
		
		RestAssured.baseURI = "http://ergast.com";
		
		Response response = RestAssured.given()
						.when()
							.get("/api/f1/2017/circuits.xml");
		
		String responseData = response.getBody().asString();
		
		XmlMapper mapper = new XmlMapper();
		
		MRData mrData = mapper.readValue(responseData, MRData.class);
		
		System.out.println(mrData.getSeries());
		System.out.println(mrData.getCircuitTable().getSeason());
		System.out.println(mrData.getCircuitTable().getCircuits().get(0).getCircuitName());
		System.out.println(mrData.getCircuitTable().getCircuits().get(0).getLocation().getLocality());
	}
}
