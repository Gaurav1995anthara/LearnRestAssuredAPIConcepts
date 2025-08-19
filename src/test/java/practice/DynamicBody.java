package practice;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DynamicBody {

	@Test
	public static void test5() throws JsonMappingException, JsonProcessingException {
		
	
	String response = "{\r\n"
			+ "    \"id\": 10,\r\n"
			+ "    \"name\": \"doggie\",\r\n"
			+ "    \"category\": {\r\n"
			+ "        \"King\" : [\r\n"
			+ "            {\r\n"
			+ "                 \"id\": 1,\r\n"
			+ "                \"name\": \"Dogs\"\r\n"
			+ "            },\r\n"
			+ "            {\r\n"
			+ "                 \"id\": 111,\r\n"
			+ "                \"name\": \"Dogs1111\"\r\n"
			+ "            }\r\n"
			+ "        ],\r\n"
			+ "\r\n"
			+ "         \"id\": 1,\r\n"
			+ "         \"name\": \"Dogs\"\r\n"
			+ "        \r\n"
			+ "    },\r\n"
			+ "    \"photoUrls\": [\r\n"
			+ "        \"hello\",\r\n"
			+ "        \"hii\"\r\n"
			+ "    ],\r\n"
			+ "    \"tags\": [\r\n"
			+ "        {\r\n"
			+ "            \"id\": 1,\r\n"
			+ "            \"name\": \"gv1\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"id\": 2,\r\n"
			+ "            \"name\": \"gv2\"\r\n"
			+ "        }\r\n"
			+ "    ],\r\n"
			+ "    \"status\": \"available\",\r\n"
			+ "    \"address\" : {\r\n"
			+ "        \"geo\" : {\r\n"
			+ "        \"latt\" : \"37\",\r\n"
			+ "        \"longg\" : \"41\"\r\n"
			+ "    },\r\n"
			+ "    \"city\" : \"mangalore\",\r\n"
			+ "    \"state\" : \"kar\"\r\n"
			+ "    },\r\n"
			+ "    \"fullname\" : \"pant\"\r\n"
			+ "}";
	
	ObjectMapper mp = new ObjectMapper();
	JsonNode root = mp.readTree(response);
	if (root.has("name")) {
	    String nameVal = root.get("name").asText();
	    System.out.println("Name: " + nameVal); // could change, so it's dynamic value
	}
	
	
	}
}
